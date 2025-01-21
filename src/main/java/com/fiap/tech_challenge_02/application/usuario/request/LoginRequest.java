package com.fiap.tech_challenge_02.application.usuario.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
