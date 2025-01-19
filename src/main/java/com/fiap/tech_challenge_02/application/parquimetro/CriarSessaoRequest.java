package com.fiap.tech_challenge_02.application.parquimetro;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CriarSessaoRequest {

    @NotBlank
    @Schema(description = "Identificador cliente")
    private String clienteId;

    @NotBlank
    @Schema(description = "Identificador estacionamento")
    private String estacionamentoId;

    @NotNull
    @Schema(description = "Quantidade horas solicitada")
    @Size(min = 1, message = "Quantidade minima 1 hora")
    private Integer quantidadeHoras;
}
