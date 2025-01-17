package com.fiap.tech_challenge_02.infrastructure.clients;

import com.fiap.tech_challenge_02.domain.pagamento.Pagamento;
import com.fiap.tech_challenge_02.domain.pagamento.StatusPagamentoEnum;
import com.fiap.tech_challenge_02.infrastructure.pagamento.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class GatewayPagamentoFake {

    private final PagamentoRepository repository;

    @Async
    public void aprovar(Pagamento request) {
        log.info("Gateway de pagamento sendo chamado ...");
        boolean aprovado = false;

        request.alterarStatus(StatusPagamentoEnum.EM_ANALISE);
        this.repository.save(request);

        try {
            Thread.sleep(60000);
            aprovado = true;
            log.info("Pagamento aprovado.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var status = aprovado ? StatusPagamentoEnum.REALIZADO : StatusPagamentoEnum.RECUSADO;
        request.alterarStatus(status);

        repository.save(request);
    }
}
