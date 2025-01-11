package com.fiap.tech_challenge_02.repository;

import com.fiap.tech_challenge_02.model.ParkingSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSessionRepository extends MongoRepository<ParkingSession, String> {
    // Exemplos de métodos personalizados:
    List<ParkingSession> findByVehiclePlate(String vehiclePlate);
    List<ParkingSession> findByParkingLotId(String parkingLotId);
}
