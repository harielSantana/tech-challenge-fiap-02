package com.fiap.tech_challenge_02.application.avaliacao;

import com.fiap.tech_challenge_02.domain.avaliacao.RealizarAvaliacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Avaliacoes")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/avaliacoes", produces = "application/json")
public class AvaliacaoController {

    private final RealizarAvaliacao realizarAvaliacao;

    @Operation(summary = "Cadastrar avaliacao do servico")
    @ResponseBody
    @PostMapping
    public ResponseEntity<String> cadastrarAvaliacao(@RequestBody @Valid CadastrarAvaliacaoRequest request) {
        log.info("Registrnado avaliacao para usuario id: {} e checkin de id: {}", request.getUsuarioId(),
                request.getSessaoId());
        realizarAvaliacao.avaliar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Avaliação cadastrada com sucesso.");
    }
}
