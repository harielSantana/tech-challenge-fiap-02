package com.fiap.tech_challenge_02.domain.cadastro;

import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import com.fiap.tech_challenge_02.infrastructure.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BuscarUsuarios {

    private final UsuarioRepository repository;

    public Usuario porId(String id) {
        return this.repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
