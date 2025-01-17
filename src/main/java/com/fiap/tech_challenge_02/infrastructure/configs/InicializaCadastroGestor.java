package com.fiap.tech_challenge_02.infrastructure.configs;

import com.fiap.tech_challenge_02.domain.cadastro.CPF;
import com.fiap.tech_challenge_02.domain.cadastro.Endereco;
import com.fiap.tech_challenge_02.domain.cadastro.TipoUsuarioEnum;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@RequiredArgsConstructor
@Configuration
public class InicializaCadastroGestor {

    private final UsuarioRepository repository;

    @PostConstruct
    void cadastraGestor() {
        String pass = Base64.getEncoder().encodeToString("123".getBytes());

        var gestor = new Usuario(null, "Gestor X", new CPF("123.123.123-12"), "admin",
                pass, "token", new Endereco(324, "15569-000"), TipoUsuarioEnum.GESTOR, "emaigestor@teste.com.br");

        repository.save(gestor);
    }
}
