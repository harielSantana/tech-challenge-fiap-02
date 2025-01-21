package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.avaliacao.Avaliacao;
import com.fiap.tech_challenge_02.domain.avaliacao.Nota;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AvaliacaoDto {

    @Schema(description = "Identificador")
    private String id;
    @Schema(description = "Nota",example = "3")
    private Nota nota;
    @Schema(description = "Comentário",example = "3")
    private String comentario;
    @Schema(description = "Cliente", implementation = UsuarioDto.class)
    private UsuarioDto cliente;
    @Schema(description = "Sessao", implementation = SessaoDto.class)
    private SessaoDto sessao;

    public static AvaliacaoDto toDTO(Avaliacao avaliacao) {
        if (avaliacao == null) {
            return null;
        }

        return AvaliacaoDto.builder()
                .id(avaliacao.getId())
                .nota(avaliacao.getNota())
                .comentario(avaliacao.getComentario())
                .cliente(UsuarioDto.toDTO(avaliacao.getCliente()))
                .sessao(SessaoDto.toDTO(avaliacao.getSessao()))
                .build();
    }
}
