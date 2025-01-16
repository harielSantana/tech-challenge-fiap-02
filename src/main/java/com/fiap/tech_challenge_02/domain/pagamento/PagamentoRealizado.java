package com.fiap.tech_challenge_02.domain.pagamento;

public class PagamentoRealizado {

    public PagamentoRealizado(Pagamento pagamento) {
        if (StatusPagamentoEnum.REALIZADO.equals(pagamento.getStatus())) {
            System.out.println("Solicita avaliacao ao cliente");
        }

        System.out.println("Enviando e-mail para " + pagamento.getUsuario().getEmail() +
                " pagamento realizado.");
    }
}
