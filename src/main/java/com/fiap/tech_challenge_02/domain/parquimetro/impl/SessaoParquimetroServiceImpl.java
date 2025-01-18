package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetro;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetroService;
import com.fiap.tech_challenge_02.infrastructure.parquimetro.SessaoParquimetroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoParquimetroServiceImpl implements SessaoParquimetroService {

    @Autowired
    private SessaoParquimetroRepository sessaoParquimetroRepository;

    @Override
    public SessaoParquimetro criar(SessaoParquimetro parkingSession) {
        return sessaoParquimetroRepository.save(parkingSession);
    }

    @Override
    public SessaoParquimetro obterPorId(String id) {
        return sessaoParquimetroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sessão não encontrada!"));
    }

    @Override
    public List<SessaoParquimetro> obterTodos() {
        return sessaoParquimetroRepository.findAll();
    }
}
