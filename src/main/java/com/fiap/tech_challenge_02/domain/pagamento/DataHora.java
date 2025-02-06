package com.fiap.tech_challenge_02.domain.pagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
public class DataHora {

    private LocalDateTime dataHora;

    public DataHora(LocalDateTime hora) {
        Objects.requireNonNull(hora, "Data e hora do pagamento não pode ser nulo");
        this.dataHora = hora;
    }
}
