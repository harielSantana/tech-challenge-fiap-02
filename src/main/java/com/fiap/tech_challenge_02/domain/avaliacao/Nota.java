package com.fiap.tech_challenge_02.domain.avaliacao;

import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Nota {

    private Integer nota;

    public Nota(Integer nota) {
        Objects.requireNonNull(nota, "Nota não pode ser nula");

        if (nota > 5 || nota < 0) {
            throw new PolicyException("Valor da nota inválida");
        }

        this.nota = nota;
    }
}
