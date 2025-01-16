package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingMeter;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-meters")
public class ParkingMeterController {

    @Autowired
    private ParkingMeterService parkingMeterService;

    @GetMapping
    public List<ParkingMeter> obterTodos() {
        return parkingMeterService.obterTodos();
    }

    @GetMapping("/{id}")
    public ParkingMeter obterPorId(@PathVariable String id) {
        return parkingMeterService.obterPorId(id);
    }

    @PostMapping
    public ParkingMeter criar(@RequestBody ParkingMeter parkingMeter) {
        return parkingMeterService.criar(parkingMeter);
    }
}

