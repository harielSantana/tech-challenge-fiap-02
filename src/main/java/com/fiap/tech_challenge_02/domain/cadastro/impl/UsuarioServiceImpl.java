package com.fiap.tech_challenge_02.domain.cadastro.impl;

import com.fiap.tech_challenge_02.application.cadastro.UsuarioRequest;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.domain.cadastro.UsuarioService;
import com.fiap.tech_challenge_02.infrastructure.cadastro.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario criar(@Valid UsuarioRequest usuarioRequest) {
        // Converter UsuarioRequest para Usuario
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setEndereco(usuarioRequest.getEndereco());
        usuario.setTpUsuario(usuarioRequest.getTpUsuario());

        return usuarioRepository.save(usuario);
    }
}
