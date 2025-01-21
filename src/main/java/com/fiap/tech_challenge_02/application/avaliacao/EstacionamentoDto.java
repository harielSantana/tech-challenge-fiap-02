package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;
@Builder
@Getter
public class EstacionamentoDto {

    private String id;
    private String nome;

    public static EstacionamentoDto toDTO(Estacionamento estacionamento) {
        if (estacionamento == null) {
            return null;
        }

        return EstacionamentoDto.builder()
                .id(estacionamento.getId())
                .nome(estacionamento.getName())
                .build();
    }
}
