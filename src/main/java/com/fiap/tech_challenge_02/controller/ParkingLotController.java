package com.fiap.tech_challenge_02.controller;

import com.fiap.tech_challenge_02.service.ParkingLotService;
import com.fiap.tech_challenge_02.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking-lots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> obterTodos() {
        return parkingLotService.obterTodos();
    }

    @GetMapping("/{id}")
    public ParkingLot obterPorId(@PathVariable String id) {
        return parkingLotService.obterPorId(id);
    }

    @PostMapping
    public ParkingLot criar(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.criar(parkingLot);
    }
}
