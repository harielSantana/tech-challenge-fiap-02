package com.fiap.tech_challenge_02.application.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@SuppressWarnings("serial")
public class LoginResponse implements Serializable {

    private String usuarioId;
    private String usuarioToken;

}
