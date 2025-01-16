package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.Tariff;
import com.fiap.tech_challenge_02.domain.parquimetro.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

