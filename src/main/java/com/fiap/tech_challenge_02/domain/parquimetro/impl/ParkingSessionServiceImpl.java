package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingSession;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingSessionService;
import com.fiap.tech_challenge_02.infrastructure.parquimetro.ParkingSessionRepository;
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
