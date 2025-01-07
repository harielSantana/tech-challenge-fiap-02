package com.fiap.tech_challenge_02.repository;

import com.fiap.tech_challenge_02.model.Tariff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends MongoRepository<Tariff, String> {
}
