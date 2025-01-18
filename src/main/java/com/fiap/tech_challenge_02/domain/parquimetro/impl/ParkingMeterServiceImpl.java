package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingMeterServiceImpl implements ParkingMeterService {

    @Autowired
    private ParkingMeterRepository parkingMeterRepository;

    @Override
    public Parquimetro criar(Parquimetro parkingMeter) {
        return parkingMeterRepository.save(parkingMeter);
    }

    @Override
    public Parquimetro obterPorId(String id) {
        return parkingMeterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Parquímetro não encontrado!"));
    }

    @Override
    public List<Parquimetro> obterTodos() {
        return parkingMeterRepository.findAll();
    }
}
