package com.fiap.tech_challenge_02.domain.cadastro.impl;


import com.fiap.tech_challenge_02.application.usuario.request.LogoutResquest;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogoutUsuarioService {

    private final UsuarioRepository repository;

    public void logout(LogoutResquest request) {
        Optional<Usuario> usuario = repository.findByToken(request.getUsuarioToken());

        if (usuario.isPresent()) {
            usuario.get().setToken(null);
            repository.save(usuario.get());
        }
    }
}
