package com.fiap.tech_challenge_02.controller;

import com.fiap.tech_challenge_02.model.ParkingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fiap.tech_challenge_02.service.ParkingSessionService;



@RestController
@RequestMapping("/parking-sessions")
public class ParkingSessionController {

    @Autowired
    private ParkingSessionService parkingSessionService;

    @GetMapping
    public List<ParkingSession> obterTodos() {
        return parkingSessionService.obterTodos();
    }

    @GetMapping("/{id}")
    public ParkingSession obterPorId(@PathVariable String id) {
        return parkingSessionService.obterPorId(id);
    }

    @PostMapping
    public ParkingSession criar(@RequestBody ParkingSession parkingSession) {
        return parkingSessionService.criar(parkingSession);
    }
}
