package com.fiap.tech_challenge_02.infrastructure.configs;

import com.fiap.tech_challenge_02.domain.cadastro.TipoUsuarioEnum;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenUsuarioInterceptor implements HandlerInterceptor {

    public static final String NAO_AUTENTICADO = "Não autenticado";
    public static final String TOKEN_INVALIDO = "Token inválido";
    public static final String ACESSO_NAO_AUTORIZADO = "Acesso não autorizado";

    private List<String> rotasBarbeiroProibidas = List.of("/filiais", "/barbeiros", "/servicos", "/filiais",
            "/filiais/barbeiros");

    private List<String> rotasUsuarioProbidas = List.of("/filiais", "/barbeiros", "/servicos", "/filiais/barbeiros",
            "/barbeiros/servicos", "barbeiros/horarios", "/clientes", "/pagamentos/barbeiros", "/agendamentos" +
                    "/confirmar/servico", "/agendamentos/barbeiros");

    private List<String> urisAutenticadas = List.of("/filiais", "/barbeiros", "/servicos", "/agendamentos", "/clientes",
            "/pagamentos");

    private final UsuarioRepository repository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String headerId = Optional.ofNullable(request.getHeader("client-id")).orElse("");
        String token = Optional.ofNullable(request.getHeader("token")).orElse("");
        String requestURI = request.getRequestURI();

        AtomicBoolean uriPrecisaEstarAutenticado = new AtomicBoolean(false);

        urisAutenticadas.forEach(uriAutenticada -> {
            if (requestURI.startsWith(uriAutenticada)) {
                uriPrecisaEstarAutenticado.set(true);
            }
        });

        if (uriPrecisaEstarAutenticado.get()) {

            if (headerId.isBlank() || token.isBlank()) {
                throw new PolicyException(NAO_AUTENTICADO);
            }

            Optional<Usuario> usuario = repository.findById(Long.valueOf(headerId));
            if (!usuario.isPresent()) {
                throw new PolicyException(NAO_AUTENTICADO);
            }

            isForbbidenPath(requestURI, usuario.get());

            String usuarioToken = usuario.get().getToken();
            if (usuarioToken == null || !token.equals(usuarioToken)) {
                throw new PolicyException(TOKEN_INVALIDO);
            }
        }

        return true;
    }

    private void isForbbidenPath(String rota, Usuario usuario) {
        if (TipoUsuarioEnum.GESTOR.equals(usuario.getTpUsuario())) {
            return;
        }

        if (TipoUsuarioEnum.BARBEIRO.equals(usuario.getTpUsuario())) {
            if (rotasBarbeiroProibidas.contains(rota)) {
                throw new PolicyException(ACESSO_NAO_AUTORIZADO);
            }
        } else if (TipoUsuarioEnum.CLIENTE.equals(usuario.getTpUsuario())) {
            if (rotasUsuarioProbidas.contains(rota)) {
                throw new PolicyException(ACESSO_NAO_AUTORIZADO);
            }
        } else {
            throw new PolicyException(ACESSO_NAO_AUTORIZADO);
        }
    }
}