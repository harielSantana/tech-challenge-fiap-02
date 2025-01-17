package com.fiap.tech_challenge_02.infrastructure.avaliacao;

import com.fiap.tech_challenge_02.domain.avaliacao.Avaliacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoClientRepository extends MongoRepository<Avaliacao, String> {
}
