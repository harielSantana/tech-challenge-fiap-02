package com.fiap.tech_challenge_02.service;

import com.fiap.tech_challenge_02.model.Tariff;

import java.util.List;

public interface TariffService {
    Tariff criar(Tariff tariff);
    Tariff obterPorId(String id);
    List<Tariff> obterTodos();
}
