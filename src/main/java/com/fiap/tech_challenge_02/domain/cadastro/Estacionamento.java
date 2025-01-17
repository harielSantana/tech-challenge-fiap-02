package com.fiap.tech_challenge_02.domain.cadastro;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Estacionamento {
    @Id
    private String id;
    private String name;
    private String location;
    private Integer capacity;
}