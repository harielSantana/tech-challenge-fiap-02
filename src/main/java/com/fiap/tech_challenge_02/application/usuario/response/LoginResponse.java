package com.fiap.tech_challenge_02.application.usuario.response;

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
