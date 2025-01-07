package com.fiap.tech_challenge_02.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

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