package com.fiap.tech_challenge_02.domain.parquimetro;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Document
public class SessaoParquimetro extends AbstractAggregateRoot<SessaoParquimetro> {
    @Id
    private String id;
    private Usuario cliente;
    private SessaoStatus status;
    private ValorSessao valor;

    @DBRef
    private Estacionamento estacionamento;

    public SessaoParquimetro(Usuario cliente, Estacionamento estacionamento, LocalDateTime entrada,
                             LocalDateTime saida) {
        Objects.requireNonNull(cliente, "Cliente nao poder ser nulo");
        Objects.requireNonNull(valor, "Valor da sessao nao pode ser nulo");
        Objects.requireNonNull(estacionamento,"Estacionamento nao pode ser nulo");

        this.cliente = cliente;
        this.estacionamento = estacionamento;
        this.valor = new ValorSessao(entrada, saida, this.estacionamento.getTarifa());
    }

    @AfterDomainEventPublication
    private void sessaoGerada() {
        registerEvent(new SessaoGerada(this));
    }
}
