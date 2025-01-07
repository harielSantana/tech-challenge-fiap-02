package com.fiap.tech_challenge_02.service;

import com.fiap.tech_challenge_02.model.ParkingMeter;
import java.util.List;

public interface ParkingMeterService {
    ParkingMeter criar(ParkingMeter parkingMeter);
    ParkingMeter obterPorId(String id);
    List<ParkingMeter> obterTodos();
}