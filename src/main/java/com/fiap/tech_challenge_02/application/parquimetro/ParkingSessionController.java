package com.fiap.tech_challenge_02.application.parquimetro;

import com.fiap.tech_challenge_02.domain.parquimetro.ParkingSession;
import com.fiap.tech_challenge_02.domain.parquimetro.ParkingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
