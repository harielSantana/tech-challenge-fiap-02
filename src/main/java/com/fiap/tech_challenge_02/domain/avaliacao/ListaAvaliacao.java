package com.fiap.tech_challenge_02.domain.avaliacao;

import com.fiap.tech_challenge_02.application.avaliacao.AvaliacaoDto;
import com.fiap.tech_challenge_02.infrastructure.avaliacao.AvaliacaoClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListaAvaliacao {

    private final AvaliacaoClientRepository repository;

    public List<AvaliacaoDto> listar() {
        return this.repository.findAll().stream()
                .map(AvaliacaoDto::toDTO)
                .toList();
    }
}
