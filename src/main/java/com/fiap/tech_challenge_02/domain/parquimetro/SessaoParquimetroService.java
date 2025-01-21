package com.fiap.tech_challenge_02.domain.parquimetro;

import com.fiap.tech_challenge_02.application.parquimetro.CriarSessaoRequest;

import java.util.List;

public interface SessaoParquimetroService {
    Parquimetro criar(CriarSessaoRequest parkingSession);

    Parquimetro obterPorId(String id);

    List<Parquimetro> obterTodos();
}
