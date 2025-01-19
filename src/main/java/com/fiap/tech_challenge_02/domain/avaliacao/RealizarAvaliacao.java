package com.fiap.tech_challenge_02.domain.avaliacao;

import com.fiap.tech_challenge_02.application.avaliacao.CadastrarAvaliacaoRequest;
import com.fiap.tech_challenge_02.domain.cadastro.BuscarUsuarios;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetroService;
import com.fiap.tech_challenge_02.infrastructure.avaliacao.AvaliacaoClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RealizarAvaliacao {

    private final BuscarUsuarios buscarUsuarios;
    private final AvaliacaoClientRepository avaliacaoRepository;
    private final SessaoParquimetroService sessaoService;

    @Transactional
    public void avaliar(CadastrarAvaliacaoRequest request) {
        var cliente = this.buscarUsuarios.porId(request.getUsuarioId());
        var sessao = this.sessaoService.obterPorId(request.getSessaoId());
        var avaliacao = new Avaliacao(new Nota(request.getNota()), request.getComentario(), cliente, sessao);

        this.avaliacaoRepository.save(avaliacao);
    }
}
