package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingMeter;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingMeterService;
import com.fiap.tech_challenge_02.infrastructure.parquimetro.ParkingMeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingMeterServiceImpl implements ParkingMeterService {

    @Autowired
    private ParkingMeterRepository parkingMeterRepository;

    @Override
    public ParkingMeter criar(ParkingMeter parkingMeter) {
        return parkingMeterRepository.save(parkingMeter);
    }

    @Override
    public ParkingMeter obterPorId(String id) {
        return parkingMeterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Parquímetro não encontrado!"));
    }

    @Override
    public List<ParkingMeter> obterTodos() {
        return parkingMeterRepository.findAll();
    }
}