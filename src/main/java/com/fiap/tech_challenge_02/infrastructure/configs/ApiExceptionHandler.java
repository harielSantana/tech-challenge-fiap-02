package com.fiap.tech_challenge_02.infrastructure.configs;

import com.fiap.tech_challenge_02.infrastructure.exceptions.EntityNotFoundException;
import com.fiap.tech_challenge_02.infrastructure.exceptions.PolicyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PolicyException.class)
    public ApiError handlePolicyException(PolicyException exception) {
        return new ApiError(400, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleException(Exception exception) {
        return new ApiError(500, exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ApiError handleException(EntityNotFoundException exception) {
        return new ApiError(404, "Recurso não encontrado");
    }

}
