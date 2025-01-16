package com.fiap.tech_challenge_02.domain.avaliacao;

public class AvaliacaoRealizada {

    public AvaliacaoRealizada(Avaliacao avaliacao) {
        System.out.println("Enviando email para getores e funcionarios");
        System.out.println("Avaliação :" + avaliacao.toString());
    }
}
