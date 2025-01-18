package com.fiap.tech_challenge_02.domain.avaliacao;

import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetro;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@ToString
@Document
public class Avaliacao extends AbstractAggregateRoot<Avaliacao> {

    @Id
    private String id;
    private Nota nota;
    private String comentario;

    @DBRef
    private Usuario cliente;
    @DBRef
    private SessaoParquimetro sessao;

    public Avaliacao(Nota nota, String comentario, Usuario usuario, SessaoParquimetro sessao) {
        Objects.requireNonNull(nota, "Nota não pode ser nula");
        Objects.requireNonNull(usuario, "Usuário não pode ser nulo");
        Objects.requireNonNull(sessao, "Sessão checkin não pode ser nulo");

        this.nota = nota;
        this.comentario = comentario;
        this.cliente = usuario;
    }

    @AfterDomainEventPublication
    private void avaliacaoRealizada() {
        registerEvent(new AvaliacaoRealizada(this));
    }
}
