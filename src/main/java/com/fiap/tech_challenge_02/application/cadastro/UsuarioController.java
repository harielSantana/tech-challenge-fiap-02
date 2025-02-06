package com.fiap.tech_challenge_02.application.cadastro;

import com.fiap.tech_challenge_02.application.avaliacao.UsuarioDto;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.domain.cadastro.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Cadastros")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/usuarios", produces = "application/json")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @Operation(summary = "Cadastro usuários")
    @PostMapping
    public UsuarioDto criar(@RequestBody UsuarioRequest usuario) {
        return UsuarioDto.toDTO(usuarioService.criar(usuario));
    }

}
