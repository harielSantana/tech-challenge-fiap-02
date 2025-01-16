package com.fiap.tech_challenge_02.domain.pagamento;

import com.fiap.tech_challenge_02.infrastructure.clients.GatewayPagamentoFake;
import com.fiap.tech_challenge_02.infrastructure.pagamento.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RealizarPagamento {

    private final GatewayPagamentoFake gatewayPagamentoFake;
    private final PagamentoRepository pagamentoRepository;

    public StatusPagamentoEnum realizar(Pagamento pagamento) {
        pagamento.alterarStatus(StatusPagamentoEnum.EM_ANALISE);

        if (TipoPagamentoEnum.NO_ESTACIONAMETO.equals(pagamento.getTipo())) {
            pagamento.alterarStatus(StatusPagamentoEnum.REALIZADO);
        } else {
            // Pagamento online
            gatewayPagamentoFake.aprovar(pagamento);
        }

        pagamentoRepository.save(pagamento);

        return pagamento.getStatus();
    }
}
