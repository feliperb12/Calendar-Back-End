package com.maykRicher.calendar.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EventosCreateDTO {

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dataInicio;


    @JsonFormat( pattern = "dd-MM-yyyy")
    private String dataFim;
}
