package com.fiap.tech_challenge_02.domain.pagamento;

import com.fiap.tech_challenge_02.application.avaliacao.PagamentoDto;
import com.fiap.tech_challenge_02.infrastructure.exceptions.EntityNotFoundException;
import com.fiap.tech_challenge_02.infrastructure.pagamento.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuscarPagamento {

    private final PagamentoRepository repository;

    public PagamentoDto buscarPagamentoPor(String id) {
        return this.repository.findBySessaoId(id)
                .map(PagamentoDto::toDTO)
                .orElseThrow(EntityNotFoundException::new);
    }
}
