package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.parquimetro.Parquimetro;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoStatus;
import com.fiap.tech_challenge_02.domain.parquimetro.ValorSessao;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SessaoDto {

    private String id;
    private UsuarioDto cliente;
    private SessaoStatus status;
    private ValorSessao valorSessao;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private EstacionamentoDto estacionamento;

    public static SessaoDto toDTO(Parquimetro sessao) {
        if (sessao == null) {
            return null;
        }

        return SessaoDto.builder()
                .cliente(UsuarioDto.toDTO(sessao.getCliente()))
                .entrada(sessao.getEntrada())
                .saida(sessao.getSaida())
                .status(sessao.getStatus())
                .estacionamento(EstacionamentoDto.toDTO(sessao.getEstacionamento()))
                .build();
    }
}
