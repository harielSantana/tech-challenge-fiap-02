package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.application.parquimetro.CriarSessaoRequest;
import com.fiap.tech_challenge_02.domain.cadastro.BuscarUsuarios;
import com.fiap.tech_challenge_02.domain.cadastro.EstacionamentoService;
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
    private BuscarUsuarios buscarUsuarios;
    private EstacionamentoService estacionamentoService;

    @Override
    public SessaoParquimetro criar(CriarSessaoRequest parkingSession) {
        var cliente = this.buscarUsuarios.porId(parkingSession.getClienteId());
        var estacionamento = this.estacionamentoService.obterPorId(parkingSession.getEstacionamentoId());

        var sessao = new SessaoParquimetro(cliente, estacionamento, parkingSession.getQuantidadeHoras());

        return sessaoParquimetroRepository.save(sessao);
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
