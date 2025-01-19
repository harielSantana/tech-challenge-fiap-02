package com.fiap.tech_challenge_02.application.cadastro;

import com.fiap.tech_challenge_02.domain.cadastro.Tarifa;
import com.fiap.tech_challenge_02.domain.cadastro.TariffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cadastros")
@RestController
@RequestMapping("/v1/tarifas")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @Operation(summary = "Listar tarifas")
    @GetMapping
    public List<Tarifa> obterTodos() {
        return tariffService.obterTodos();
    }

    @Operation(summary = "Obter tarifa por id")
    @GetMapping("/{id}")
    public Tarifa obterPorId(@PathVariable String id) {
        return tariffService.obterPorId(id);
    }

    @Operation(summary = "Registrar nova tarifa")
    @PostMapping
    public Tarifa criar(@RequestBody Tarifa tariff) {
        return tariffService.criar(tariff);
    }
}

