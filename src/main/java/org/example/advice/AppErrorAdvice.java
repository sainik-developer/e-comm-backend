package org.example.advice;

import org.example.dto.BaseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;

@RestControllerAdvice
public class AppErrorAdvice {
    @ExceptionHandler(value = LoginException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public BaseErrorDTO loginException(final Exception e) {
        return new BaseErrorDTO("Otp verification failed!");
    }
}
