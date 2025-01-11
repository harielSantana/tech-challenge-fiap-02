package com.fiap.tech_challenge_02.service.impl;

import com.fiap.tech_challenge_02.model.ParkingSession;
import com.fiap.tech_challenge_02.repository.ParkingSessionRepository;
import com.fiap.tech_challenge_02.service.ParkingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSessionServiceImpl implements ParkingSessionService {

    @Autowired
    private ParkingSessionRepository parkingSessionRepository;

    @Override
    public ParkingSession criar(ParkingSession parkingSession) {
        return parkingSessionRepository.save(parkingSession);
    }

    @Override
    public ParkingSession obterPorId(String id) {
        return parkingSessionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sessão não encontrada!"));
    }

    @Override
    public List<ParkingSession> obterPorPlaca(String vehiclePlate) {
        return parkingSessionRepository.findByVehiclePlate(vehiclePlate);
    }

    @Override
    public List<ParkingSession> obterTodos() {
        return parkingSessionRepository.findAll();
    }
}
