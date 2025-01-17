package com.fiap.tech_challenge_02.domain.cadastro.impl;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import com.fiap.tech_challenge_02.domain.cadastro.EstacionamentoService;
import com.fiap.tech_challenge_02.infrastructure.cadastro.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionamentoServiceImpl implements EstacionamentoService {

    @Autowired
    private EstacionamentoRepository repository;

    @Override
    public Estacionamento criar(Estacionamento parkingLot) {
        // Salva o estacionamento no banco de dados
        return repository.save(parkingLot);
    }

    @Override
    public Estacionamento obterPorId(String id) {
        // Busca o estacionamento pelo ID
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estacionamento não encontrado com ID: " + id));
    }

    @Override
    public List<Estacionamento> obterTodos() {
        // Retorna todos os estacionamentos
        return repository.findAll();
    }
}
