package com.fiap.tech_challenge_02.infrastructure.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {

    private Integer codeStatus;
    private String message;

}
