package com.fiap.tech_challenge_02.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@Document
public class Tariff {
    @Id
    private String id;
    private Double hourlyRate;
    private Double maxDailyRate;

    @DBRef
    private ParkingLot parkingLot;
}
