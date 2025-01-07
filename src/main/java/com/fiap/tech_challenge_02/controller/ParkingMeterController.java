package com.fiap.tech_challenge_02.controller;

import com.fiap.tech_challenge_02.model.ParkingMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fiap.tech_challenge_02.service.ParkingMeterService;

import java.util.List;

@RestController
@RequestMapping(value = "/parking-meters")
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

