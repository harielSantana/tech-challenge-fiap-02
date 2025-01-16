package com.fiap.tech_challenge_02.domain.parquimetro;

import java.util.List;

public interface ParkingLotService {
    ParkingLot criar(ParkingLot parkingLot);

    ParkingLot obterPorId(String id);

    List<ParkingLot> obterTodos();
}
