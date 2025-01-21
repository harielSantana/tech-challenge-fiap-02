package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.pagamento.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PagamentoDto {

    @Schema(description = "Identificador", example = "1")
    private String id;
    @Schema(description = "Data e hora pagamento")
    private DataHora dataHora;
    @Schema(description = "Valor do pagamento", example = "4")
    private ValorPagamento valor;
    @Schema(description = "Forma de Pagamento", example = "CARTAO")
    private TipoPagamentoEnum tipo;
    @Schema(description = "Status do pagamento", example = "EM_ANALISE")
    private StatusPagamentoEnum status;
    @Schema(description = "Cliente", implementation = UsuarioDto.class)
    private UsuarioDto cliente;
    @Schema(description = "Sessao", implementation = SessaoDto.class)
    private SessaoDto sessao;

    public static PagamentoDto toDTO(Pagamento pagamento) {
        return PagamentoDto.builder()
                .cliente(UsuarioDto.toDTO(pagamento.getUsuario()))
                .dataHora(pagamento.getDataHora())
                .tipo(pagamento.getTipo())
                .status(pagamento.getStatus())
                .sessao(SessaoDto.toDTO(pagamento.getSessao()))
                .build();
    }
}
