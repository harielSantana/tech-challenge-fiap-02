package com.fiap.tech_challenge_02.application.pagamento;

import com.fiap.tech_challenge_02.domain.pagamento.TipoPagamentoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PagamentoRequest {

    @NotBlank
    @Schema(description = "Id checkin do veículo")
    private String sessaoId;
    @Schema(description = "Id do cliente")
    private String usuarioId;
    @Schema(description = "Tipo do Pagamento", example = "NO_ESTACIONAMENTO")
    private TipoPagamentoEnum tipoPagamento;
}
