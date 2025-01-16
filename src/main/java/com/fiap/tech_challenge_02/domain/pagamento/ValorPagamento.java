package com.fiap.tech_challenge_02.domain.pagamento;

import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class ValorPagamento {

    private BigDecimal valor;

    public ValorPagamento(BigDecimal valor) {
        Objects.requireNonNull(valor, "Data e hora do pagamento não pode ser nulo");

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PolicyException("Valor de pagamento não pode ser menor ou igual a zero");
        }

        this.valor = valor;
    }
}
