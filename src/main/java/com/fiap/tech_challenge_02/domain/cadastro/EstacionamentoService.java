package com.fiap.tech_challenge_02.domain.cadastro;

import java.util.List;

public interface EstacionamentoService {
    Estacionamento criar(Estacionamento parkingLot);

    Estacionamento obterPorId(String id);

    List<Estacionamento> obterTodos();
}
