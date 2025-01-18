package com.fiap.tech_challenge_02.domain.cadastro;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Tarifa {
    @Id
    private String id;
    private Double hourlyRate;
    private Double maxDailyRate;
}
