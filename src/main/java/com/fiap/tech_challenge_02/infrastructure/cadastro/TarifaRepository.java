package com.fiap.tech_challenge_02.infrastructure.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.Tarifa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends MongoRepository<Tarifa, String> {
}
