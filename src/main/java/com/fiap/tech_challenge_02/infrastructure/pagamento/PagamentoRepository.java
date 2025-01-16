package com.fiap.tech_challenge_02.infrastructure.pagamento;

import com.fiap.tech_challenge_02.domain.pagamento.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, Long> {
//
//    Optional<PagamentoServicoAgendado> findByAgendamentoServico(AgendamentoServico agendamentoServico);
//
//    Optional<PagamentoServicoAgendado> findByAgendamentoServicoId(String id);
//
//    ArrayList<PagamentoServicoAgendado> findByAgendamentoServicoBarbeiroId(Long barbeiroId);
}
