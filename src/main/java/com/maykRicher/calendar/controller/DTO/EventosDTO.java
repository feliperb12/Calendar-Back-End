package com.maykRicher.calendar.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.maykRicher.calendar.model.Eventos;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    // @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Valid
    private String dataInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Valid
    private String dataFim;


    public EventosDTO(Eventos obj) {
        super();
        this.id = obj.getId();
        this.dataInicio = obj.getDataInicio();
        this.dataFim = obj.getDataFim();

    }

    public EventosDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }


}
