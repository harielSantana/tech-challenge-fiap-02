package com.fiap.tech_challenge_02.service.impl;

import com.fiap.tech_challenge_02.model.ParkingLot;
import com.fiap.tech_challenge_02.repository.ParkingLotRepository;
import com.fiap.tech_challenge_02.service.ParkingLotService;
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
