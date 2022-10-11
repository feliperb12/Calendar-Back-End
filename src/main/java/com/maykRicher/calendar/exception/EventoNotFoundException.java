package com.maykRicher.calendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {
    public EventoNotFoundException(Integer id){
        super("Evento não foi encontrado com o Id:" + id);
    }


}
