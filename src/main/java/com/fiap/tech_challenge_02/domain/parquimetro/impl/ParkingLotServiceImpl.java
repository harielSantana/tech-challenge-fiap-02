package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingLot;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingLotService;
import com.fiap.tech_challenge_02.infrastructure.parquimetro.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLot criar(ParkingLot parkingLot) {
        // Salva o estacionamento no banco de dados
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot obterPorId(String id) {
        // Busca o estacionamento pelo ID
        return parkingLotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estacionamento não encontrado com ID: " + id));
    }

    @Override
    public List<ParkingLot> obterTodos() {
        // Retorna todos os estacionamentos
        return parkingLotRepository.findAll();
    }
}
