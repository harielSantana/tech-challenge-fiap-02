package com.fiap.tech_challenge_02.domain.pagamento;

import com.fiap.tech_challenge_02.domain.cadastro.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Pagamento extends AbstractAggregateRoot<Pagamento> {

    @Id
    private String id;
    private DataHora dataHora;
    private ValorPagamento valor;
    private TipoPagamentoEnum tipo;
    private StatusPagamentoEnum status;
    @DBRef
    private Usuario usuario;

    public void pagamentoRealizado() {
        registerEvent(new PagamentoRealizado(this));
    }

    public void alterarStatus(StatusPagamentoEnum status) {
        Objects.requireNonNull(status, "Status não pode ser nulo");
        this.status = status;
        this.dataHora = new DataHora(LocalDateTime.now());
    }

}
