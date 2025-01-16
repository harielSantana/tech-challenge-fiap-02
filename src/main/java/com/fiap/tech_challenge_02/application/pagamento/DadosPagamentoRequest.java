package com.fiap.tech_challenge_02.application.pagamento;

import com.fiap.tech_challenge_02.domain.pagamento.TipoPagamentoEnum;
import lombok.Getter;

@Getter
public class DadosPagamentoRequest {

    private Long agendamentoId;
    private TipoPagamentoEnum tpPagamento;
    private String nomeCartao;
    private String numeroCartao;
    private String vencimentoCartao;
    private Integer cvc;

}
