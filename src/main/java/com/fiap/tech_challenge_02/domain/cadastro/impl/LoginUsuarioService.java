package com.fiap.tech_challenge_02.domain.cadastro.impl;

import com.fiap.tech_challenge_02.application.usuario.request.LoginRequest;
import com.fiap.tech_challenge_02.application.usuario.response.LoginResponse;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoginUsuarioService {

    private final UsuarioRepository repository;

    public LoginResponse login(@Valid LoginRequest request) {
        Optional<Usuario> usuario = repository.findByUsernameAndPassword(request.getUsername(),
                Base64.getEncoder().encodeToString(request.getPassword().getBytes()));

        if (!usuario.isPresent()) {
            throw new PolicyException("Dados inválidos");
        }

        if (usuario.get().getToken() == null || usuario.get().getToken().isBlank()) {
            usuario.get().setToken(UUID.randomUUID().toString());
            repository.save(usuario.get());
        }

        return new LoginResponse(usuario.get().getId(), usuario.get().getToken());
    }
}
