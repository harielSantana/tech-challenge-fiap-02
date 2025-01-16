package com.fiap.tech_challenge_02.infrastructure.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingLot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends MongoRepository<ParkingLot, String> {
}
