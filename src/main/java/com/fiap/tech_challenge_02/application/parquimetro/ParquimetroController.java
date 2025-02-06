package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Parquimetro")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/parquimetro/sessoes")
public class ParquimetroController {

    @Autowired
    private SessaoParquimetroService sessaoParquimetroService;

    @Operation(summary = "Listar todas sessoes")
    @GetMapping
    public List<ParquimetroDTO> obterTodos() {
        return sessaoParquimetroService.obterTodos().stream()
                .map(ParquimetroDTO::toDTO)
                .toList();
    }

    @Operation(summary = "Obter uma sessao por id")
    @GetMapping("/{id}")
    public ParquimetroDTO obterPorId(@PathVariable String id) {
        return ParquimetroDTO.toDTO(sessaoParquimetroService.obterPorId(id));
    }

    @Operation(summary = "Registrar nova sessao do cliente no parquimetro")
    @PostMapping
    public ParquimetroDTO criar(@RequestBody CriarSessaoRequest sessao) {
        return  ParquimetroDTO.toDTO(sessaoParquimetroService.criar(sessao));
    }
}
