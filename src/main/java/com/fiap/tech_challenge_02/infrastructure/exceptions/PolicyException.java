package com.fiap.tech_challenge_02.infrastructure.exceptions;

@SuppressWarnings("serial")
public class PolicyException extends RuntimeException {

    public PolicyException(String politica) {
        super(politica);
    }
}
