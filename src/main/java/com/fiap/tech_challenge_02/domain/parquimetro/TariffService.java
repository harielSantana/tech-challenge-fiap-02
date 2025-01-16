package com.fiap.tech_challenge_02.domain.parquimetro;

import java.util.List;

public interface TariffService {
    Tariff criar(Tariff tariff);

    Tariff obterPorId(String id);

    List<Tariff> obterTodos();
}
