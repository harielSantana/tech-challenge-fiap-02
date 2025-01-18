package com.fiap.tech_challenge_02.domain.parquimetro;

import com.fiap.tech_challenge_02.domain.cadastro.Tarifa;
import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class ValorSessao {

    private BigDecimal valor;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public ValorSessao(LocalDateTime entrada, LocalDateTime saida, Tarifa tarifa) {
        Objects.requireNonNull(entrada,"Data hora entrada sessao nao pode ser nula");
        Objects.requireNonNull(saida,"Data hora saida sessao nao pode ser nula");
        Objects.requireNonNull(tarifa,"Tarifa sessao nao pode ser nula");

        Double valorHora = tarifa.getHourlyRate();
        if (valorHora == null || valorHora == 0) {
            throw new PolicyException("Valor da sessao não pode ser gerado com uma tarifa inválida");
        }

        long tempoPercorrido = Duration.between(entrada, saida).toHours();

        // tempo minino 1h
        if (tempoPercorrido < 1) {
            tempoPercorrido = 1;
        }

        this.valor = new BigDecimal(valorHora).multiply(new BigDecimal(tempoPercorrido));
    }
}
