package com.fiap.tech_challenge_02.application.parquimetro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-meters")
public class ParkingMeterController {

    @Autowired
    private ParkingMeterService parkingMeterService;

    @GetMapping
    public List<Parquimetro> obterTodos() {
        return parkingMeterService.obterTodos();
    }

    @GetMapping("/{id}")
    public Parquimetro obterPorId(@PathVariable String id) {
        return parkingMeterService.obterPorId(id);
    }

    @PostMapping
    public Parquimetro criar(@RequestBody Parquimetro parkingMeter) {
        return parkingMeterService.criar(parkingMeter);
    }
}

