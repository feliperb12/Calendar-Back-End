package com.maykRicher.calendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContasNotFoundException extends RuntimeException{

    public ContasNotFoundException(Integer id){
        super("Conta com id " + id + " não foi encontrada");
    }
}
