package com.fiap.tech_challenge_02.application.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.Estacionamento;
import com.fiap.tech_challenge_02.domain.cadastro.impl.EstacionamentoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cadastros")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoServiceImpl estacionamentoService;

    @Operation(summary = "Listar estacionamentos")
    @GetMapping
    public List<Estacionamento> obterTodos() {
        return estacionamentoService.obterTodos();
    }

    @Operation(summary = "Obter estacionamento por identificador")
    @GetMapping("/{id}")
    public Estacionamento obterPorId(@PathVariable String id) {
        return estacionamentoService.obterPorId(id);
    }

    @Operation(summary = "Registrar novo estacionamento")
    @PostMapping
    public Estacionamento criar(@RequestBody Estacionamento estacionamento) {
        return estacionamentoService.criar(estacionamento);
    }
}
