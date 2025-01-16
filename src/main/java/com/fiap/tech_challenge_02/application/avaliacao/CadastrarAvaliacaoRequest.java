package com.fiap.tech_challenge_02.application.avaliacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CadastrarAvaliacaoRequest {

    @NotNull
    private Long pagamentoId;
    @NotNull
    private String comentario;
    @Size(min = 0, max = 5)
    @NotNull
    private Integer nota;
}
