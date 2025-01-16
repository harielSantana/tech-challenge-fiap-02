package com.fiap.tech_challenge_02.domain.cadastro;

import lombok.Getter;

@Getter
public class Endereco {

    private Integer numero;
    private String lougradouro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(Integer numero, String cep) {
        this.numero = numero;
        this.cep = cep;

        var dadosCep = "Busca endereco Api do Cep".concat(cep);

        this.lougradouro = dadosCep;
        this.cidade = dadosCep;
        this.estado = dadosCep;
    }
}
