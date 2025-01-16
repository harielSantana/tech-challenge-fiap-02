package com.fiap.tech_challenge_02.application.pagamento;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Pagamentos")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pagamentos", produces = "application/json")
public class PagamentoController {

//    private final ListaPagamentoBarbeiroService listaPagamentoBarbeiroService;
//
//    @Operation(summary = "Lista status pagamentos servico barbeiro")
//    @PostMapping("/barbeiros")
//    public ResponseEntity<Void> confirmarServicoRealizado(@RequestBody @Valid PagamentoBarbeiroRequest request) {
//        log.info("Lista status pagamentos para serviço do barbeiro de id: {}", request.getBarbeiroId());
//        ArrayList<PagamentoBarbeiroResponse> response = listaPagamentoBarbeiroService.listar(request);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
}
