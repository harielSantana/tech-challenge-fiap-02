package com.fiap.tech_challenge_02.domain.pagamento;

import com.fiap.tech_challenge_02.domain.cadastro.BuscarUsuarios;
import com.fiap.tech_challenge_02.application.pagamento.PagamentoRequest;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingSessionService;
import com.fiap.tech_challenge_02.infrastructure.clients.GatewayPagamentoFake;
import com.fiap.tech_challenge_02.infrastructure.pagamento.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class RealizarPagamento {

    private final BuscarUsuarios buscarUsuarios;
    private final ParkingSessionService sessaoService;
    private final GatewayPagamentoFake gatewayPagamentoFake;
    private final PagamentoRepository pagamentoRepository;

    @Transactional
    public StatusPagamentoEnum realizar(PagamentoRequest request) {
        var cliente = this.buscarUsuarios.porId(request.getUsuarioId());
        var sessao = this.sessaoService.obterPorId(request.getSessaoId());

        var pagamento = new Pagamento(new BigDecimal(sessao.getTotalAmount()), request.getTipoPagamento(), cliente,
                sessao);

        this.pagamentoRepository.save(pagamento);

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
