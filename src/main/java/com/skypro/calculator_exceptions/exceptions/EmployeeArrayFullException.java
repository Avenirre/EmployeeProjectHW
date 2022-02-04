package com.skypro.calculator_exceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayFullException extends RuntimeException{

    public EmployeeArrayFullException(String message) {
        super(message);
    }
}
