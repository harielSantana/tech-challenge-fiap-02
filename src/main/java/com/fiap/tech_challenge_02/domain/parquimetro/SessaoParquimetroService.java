package com.fiap.tech_challenge_02.domain.parquimetro;

import com.fiap.tech_challenge_02.application.parquimetro.CriarSessaoRequest;

import java.util.List;

public interface SessaoParquimetroService {
    SessaoParquimetro criar(CriarSessaoRequest parkingSession);

    SessaoParquimetro obterPorId(String id);

    List<SessaoParquimetro> obterTodos();
}
