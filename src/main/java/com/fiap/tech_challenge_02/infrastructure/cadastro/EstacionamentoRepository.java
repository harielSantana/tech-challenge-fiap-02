package com.fiap.tech_challenge_02.infrastructure.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoRepository extends MongoRepository<Estacionamento, String> {
}
