package com.fiap.tech_challenge_02.service.impl;

import com.fiap.tech_challenge_02.model.Tariff;
import com.fiap.tech_challenge_02.repository.TariffRepository;
import com.fiap.tech_challenge_02.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {


    @Autowired
    private TariffRepository tariffRepository;

    @Override
    public Tariff criar(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff obterPorId(String id) {
        return tariffRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarifa não encontrada!"));
    }

    @Override
    public List<Tariff> obterTodos() {
        return tariffRepository.findAll();
    }
}
