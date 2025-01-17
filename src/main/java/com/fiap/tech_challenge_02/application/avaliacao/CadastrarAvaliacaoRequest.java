package com.fiap.tech_challenge_02.application.avaliacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CadastrarAvaliacaoRequest {

    @NotBlank
    @Schema(description = "Id checkin do veículo")
    private String sessaoId;
    @Schema(description = "Id do cliente/avaliador")
    private String usuarioId;
    @NotNull
    @Schema(description = "Comentário avaliação", example = "Ótimo atendimento e estrutura acomodante")
    private String comentario;
    @Size(min = 0, max = 5)
    @NotNull
    @Schema(description = "Comentário avaliação", example = "5")
    private Integer nota;

}
