package com.fiap.tech_challenge_02.domain.cadastro;

import java.util.List;

public interface TariffService  {
    Tarifa criar(Tarifa tariff);
    Tarifa obterPorId(String id);
    List<Tarifa> obterTodos();
}
