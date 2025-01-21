package com.fiap.tech_challenge_02.infrastructure.pagamento;

import com.fiap.tech_challenge_02.application.avaliacao.PagamentoDto;
import com.fiap.tech_challenge_02.domain.pagamento.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, Long> {

    Optional<Pagamento> findBySessaoId(String id);
}
