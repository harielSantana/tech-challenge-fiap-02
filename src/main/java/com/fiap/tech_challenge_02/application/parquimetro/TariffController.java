package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.cadastro.Tarifa;
import com.fiap.tech_challenge_02.domain.cadastro.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/tariffs")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @GetMapping
    public List<Tarifa> obterTodos() {
        return tariffService.obterTodos();
    }

    @GetMapping("/{id}")
    public Tarifa obterPorId(@PathVariable String id) {
        return tariffService.obterPorId(id);
    }

    @PostMapping
    public Tarifa criar(@RequestBody Tarifa tariff) {
        return tariffService.criar(tariff);
    }
}

