package com.fiap.tech_challenge_02.domain.parquimetro;

import java.util.List;

public interface ParkingSessionService {
    ParkingSession criar(ParkingSession parkingSession);

    ParkingSession obterPorId(String id);

    List<ParkingSession> obterPorPlaca(String vehiclePlate);

    List<ParkingSession> obterTodos();
}
