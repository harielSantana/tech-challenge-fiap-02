package com.fiap.tech_challenge_02.service.impl;

import com.fiap.tech_challenge_02.model.ParkingMeter;
import com.fiap.tech_challenge_02.repository.ParkingMeterRepository;
import com.fiap.tech_challenge_02.service.ParkingMeterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
