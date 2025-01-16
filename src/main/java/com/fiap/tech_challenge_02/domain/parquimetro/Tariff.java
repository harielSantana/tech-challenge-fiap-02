package com.fiap.tech_challenge_02.domain.parquimetro;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
