package com.fiap.tech_challenge_02.domain.parquimetro;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class ParkingSession {
    @Id
    private String id;
    private String vehiclePlate;
    private String meterId;

    @DBRef
    private ParkingLot parkingLot;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalAmount;
    private ParkingStatus status;
}