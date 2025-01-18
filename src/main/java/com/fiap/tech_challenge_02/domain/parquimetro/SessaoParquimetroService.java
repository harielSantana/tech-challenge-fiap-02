package com.fiap.tech_challenge_02.domain.parquimetro;

import java.util.List;

public interface SessaoParquimetroService {
    SessaoParquimetro criar(SessaoParquimetro parkingSession);
    SessaoParquimetro obterPorId(String id);
    List<SessaoParquimetro> obterTodos();
}
