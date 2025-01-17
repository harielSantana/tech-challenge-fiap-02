package com.fiap.tech_challenge_02.application.pagamento;

import com.fiap.tech_challenge_02.domain.pagamento.RealizarPagamento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pagamentos")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/pagamentos", produces = "application/json")
public class PagamentoController {

    private final RealizarPagamento realizarPagamento;

    @Operation(summary = "Registrar pagamento pelo cliente")
    @PostMapping
    public ResponseEntity<Void> realizarPagamento(@RequestBody @Valid PagamentoRequest request) {
        log.info("Registrando pagamento do cliente de id: {}, para a sessao de id: {}",
                request.getUsuarioId(), request.getSessaoId());
        this.realizarPagamento.realizar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
