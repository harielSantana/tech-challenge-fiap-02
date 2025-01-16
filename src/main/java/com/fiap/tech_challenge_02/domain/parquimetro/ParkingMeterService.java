package com.fiap.tech_challenge_02.domain.parquimetro;

import java.util.List;

public interface ParkingMeterService {
    ParkingMeter criar(ParkingMeter parkingMeter);

    ParkingMeter obterPorId(String id);

    List<ParkingMeter> obterTodos();
}