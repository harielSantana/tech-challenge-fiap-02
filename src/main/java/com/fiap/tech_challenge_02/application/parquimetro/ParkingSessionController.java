package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetro;
import com.fiap.tech_challenge_02.domain.parquimetro.SessaoParquimetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking-sessions")
public class ParkingSessionController {

    @Autowired
    private SessaoParquimetroService sessaoParquimetroService;

    @GetMapping
    public List<SessaoParquimetro> obterTodos() {
        return sessaoParquimetroService.obterTodos();
    }

    @GetMapping("/{id}")
    public SessaoParquimetro obterPorId(@PathVariable String id) {
        return sessaoParquimetroService.obterPorId(id);
    }

    @PostMapping
    public SessaoParquimetro criar(@RequestBody SessaoParquimetro parkingSession) {
        return sessaoParquimetroService.criar(parkingSession);
    }
}
