package com.fiap.tech_challenge_02.domain.cadastro;

import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import lombok.Getter;

import java.util.Objects;

@Getter
public class CPF {
    private String cpfCnpj;

    public CPF(String cpfCnpj) {
        Objects.requireNonNull(cpfCnpj, "Cpf/Cnpj nao pode ser nulo");

        String avaliador = cpfCnpj.replaceAll("\\.", "")
                .replaceAll("-", "")
                .replaceAll("/", "");

        if (avaliador.length() < 11 || avaliador.length() > 14) {
            throw new PolicyException("Cpf/Cnpj inválido");
        }

        this.cpfCnpj = cpfCnpj;
    }

    public String getCpfCnpjSemFormatacao() {
        return this.cpfCnpj.replaceAll("\\.", "")
                .replaceAll("-", "")
                .replaceAll("/", "");
    }

    public String getCpfFormatado() {
        String retorno = this.getCpfCnpjSemFormatacao();

        if (retorno.length() == 11) {
            return new StringBuilder(retorno.substring(0, 2))
                    .append(".").append(retorno.substring(3, 5))
                    .append(".").append(retorno.substring(6, 8))
                    .append("-").append(retorno.substring(9, 10))
                    .toString();
        }

        return new StringBuilder(retorno.substring(0, 1))
                .append(".").append(retorno.substring(2, 4))
                .append(".").append(retorno.substring(5, 7))
                .append("/").append(retorno.substring(8, 11))
                .append("-").append(retorno.substring(12, 13))
                .toString();
    }
}
