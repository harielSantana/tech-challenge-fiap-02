package com.fiap.tech_challenge_02.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@Document
public class ParkingMeter {
    @Id
    private String id;
    private String location;

    @DBRef
    private ParkingLot parkingLot;

    private boolean isOperational;
}