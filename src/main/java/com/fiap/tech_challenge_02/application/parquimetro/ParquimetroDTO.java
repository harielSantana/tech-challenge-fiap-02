package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.application.avaliacao.EstacionamentoDto;
import com.fiap.tech_challenge_02.application.avaliacao.UsuarioDto;
import com.fiap.tech_challenge_02.domain.parquimetro.Parquimetro;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoStatus;
import com.fiap.tech_challenge_02.domain.parquimetro.ValorSessao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParquimetroDTO {

    private String id;
    private UsuarioDto cliente;
    private SessaoStatus status;
    private ValorSessao valorSessao;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private EstacionamentoDto estacionamento;

    public static ParquimetroDTO toDTO(Parquimetro parquimetro) {
        return ParquimetroDTO.builder()
                .id(parquimetro.getId())
                .entrada(parquimetro.getEntrada())
                .saida(parquimetro.getSaida())
                .cliente(UsuarioDto.toDTO(parquimetro.getCliente()))
                .estacionamento(EstacionamentoDto.toDTO(parquimetro.getEstacionamento()))
                .valorSessao(parquimetro.getValorSessao())
                .status(parquimetro.getStatus())
                .build();
    }
}
