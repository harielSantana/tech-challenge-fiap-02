package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioDto {

    private String id;
    private String nome;

    public static UsuarioDto toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .build();
    }
}
