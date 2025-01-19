package com.fiap.tech_challenge_02.domain.cadastro.impl;

import com.fiap.tech_challenge_02.domain.cadastro.Tarifa;
import com.fiap.tech_challenge_02.domain.cadastro.TariffService;
import com.fiap.tech_challenge_02.infrastructure.cadastro.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {


    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public Tarifa criar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    @Override
    public Tarifa obterPorId(String id) {
        return tarifaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarifa não encontrada!"));
    }

    @Override
    public List<Tarifa> obterTodos() {
        return tarifaRepository.findAll();
    }
}
