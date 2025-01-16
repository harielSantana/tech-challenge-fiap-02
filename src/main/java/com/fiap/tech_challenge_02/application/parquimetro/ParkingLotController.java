package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingLot;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lots")
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
