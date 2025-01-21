package com.fiap.tech_challenge_02.domain.parquimetro;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Document
public class Parquimetro extends AbstractAggregateRoot<Parquimetro> {
    @Id
    private String id;
    @DBRef
    private Usuario cliente;
    private SessaoStatus status;
    private ValorSessao valorSessao;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    @DBRef
    private Estacionamento estacionamento;

    public Parquimetro(Usuario cliente, Estacionamento estacionamento, Integer quantidadeHoras) {
        Objects.requireNonNull(cliente, "Cliente nao poder ser nulo");
        Objects.requireNonNull(estacionamento, "Estacionamento nao pode ser nulo");
        Objects.requireNonNull(quantidadeHoras, "Quantidade de horas da sessao nao pode ser nulo");

        this.cliente = cliente;
        this.estacionamento = estacionamento;
        this.entrada = LocalDateTime.now();
        this.saida = entrada.plusHours(quantidadeHoras.longValue());
        this.valorSessao = new ValorSessao(entrada, saida, this.estacionamento.getTarifa());
        this.status = SessaoStatus.ACTIVE;
    }

    @AfterDomainEventPublication
    private void sessaoGerada() {
        registerEvent(new SessaoGerada(this));
    }

    public void realizarSaida() {
        this.saida = LocalDateTime.now();
        this.valorSessao = new ValorSessao(this.entrada, this.saida, this.estacionamento.getTarifa());
        this.status = SessaoStatus.COMPLETED;
    }

    public SessaoStatus verificarStatus() {
        if (SessaoStatus.ACTIVE == this.status &&
                (LocalDateTime.now().isAfter(this.saida))) {
            this.status = SessaoStatus.EXPIRED;
            this.valorSessao = new ValorSessao(this.entrada, LocalDateTime.now(), this.estacionamento.getTarifa());
        }

        return this.status;
    }
}
