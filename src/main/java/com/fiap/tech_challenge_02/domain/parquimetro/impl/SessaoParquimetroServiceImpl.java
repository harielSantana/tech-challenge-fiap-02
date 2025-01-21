package com.fiap.tech_challenge_02.domain.parquimetro.impl;

import com.fiap.tech_challenge_02.application.parquimetro.CriarSessaoRequest;
import com.fiap.tech_challenge_02.domain.cadastro.BuscarUsuarios;
import com.fiap.tech_challenge_02.domain.cadastro.EstacionamentoService;
import com.fiap.tech_challenge_02.domain.parquimetro.Parquimetro;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetroService;
import com.fiap.tech_challenge_02.infrastructure.parquimetro.SessaoParquimetroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SessaoParquimetroServiceImpl implements SessaoParquimetroService {

    private final SessaoParquimetroRepository sessaoParquimetroRepository;
    private final BuscarUsuarios buscarUsuarios;
    private final EstacionamentoService estacionamentoService;

    @Override
    public Parquimetro criar(CriarSessaoRequest parkingSession) {
        var cliente = this.buscarUsuarios.porId(parkingSession.getClienteId());
        var estacionamento = this.estacionamentoService.obterPorId(parkingSession.getEstacionamentoId());

        var sessao = new Parquimetro(cliente, estacionamento, parkingSession.getQuantidadeHoras());

        return sessaoParquimetroRepository.save(sessao);
    }

    @Override
    public Parquimetro obterPorId(String id) {
        return sessaoParquimetroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sessão não encontrada!"));
    }

    @Override
    public List<Parquimetro> obterTodos() {
        return sessaoParquimetroRepository.findAll();
    }
}
