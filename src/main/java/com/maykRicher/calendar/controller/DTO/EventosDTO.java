package com.maykRicher.calendar.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.maykRicher.calendar.model.Eventos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;
   // @JsonFormat(pattern = "dd-MM-yyyy")
    private Date start;


    public EventosDTO(Eventos obj) {
        super();
        this.id = obj.getId();
        this.start = obj.getStart();
        this.title= obj.getTitle();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
