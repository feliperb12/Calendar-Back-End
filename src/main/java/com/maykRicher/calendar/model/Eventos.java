package com.maykRicher.calendar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Eventos {
    @Id
    private Integer id;

    private String dataInicio;
    private String dataFim;
    private LocalDateTime dataInicioDate;
    private LocalDateTime dataFimDate;

    public Eventos() {
    }

    public Eventos(Integer id, String dataInicio, String dataFim) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Eventos(Integer id, LocalDateTime dataInicioDate, LocalDateTime dataFimDate) {
        this.id = id;
        this.dataInicioDate = dataInicioDate;
        this.dataFimDate = dataFimDate;
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

    public LocalDateTime getDataInicioDate() {
        return dataInicioDate;
    }

    public void setDataInicioDate(LocalDateTime dataInicioDate) {
        this.dataInicioDate = dataInicioDate;
    }

    public LocalDateTime getDataFimDate() {
        return dataFimDate;
    }

    public void setDataFimDate(LocalDateTime dataFimDate) {
        this.dataFimDate = dataFimDate;
    }
}
