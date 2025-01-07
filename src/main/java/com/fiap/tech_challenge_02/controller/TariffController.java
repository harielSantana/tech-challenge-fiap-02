package com.fiap.tech_challenge_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/tariffs")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @GetMapping
    public List<Tariff> obterTodos() {
        return tariffService.obterTodos();
    }

    @GetMapping("/{id}")
    public Tariff obterPorId(@PathVariable String id) {
        return tariffService.obterPorId(id);
    }

    @PostMapping
    public Tariff criar(@RequestBody Tariff tariff) {
        return tariffService.criar(tariff);
    }
}

