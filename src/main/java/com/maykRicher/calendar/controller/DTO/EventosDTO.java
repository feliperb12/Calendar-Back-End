package com.maykRicher.calendar.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.maykRicher.calendar.model.Eventos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventosDTO {

        private Integer id;

        private String dataInicio;
        private String dataFim;
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        private LocalDateTime dataInicioDate;
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        private LocalDateTime dataFimDate;

        public EventosDTO(Eventos obj) {
                this.id= obj.getId();
                this.dataInicio= obj.getDataInicio();
                this.dataFim= obj.getDataFim();
                this.dataInicioDate= obj.getDataInicioDate();
                this.dataFimDate= obj.getDataFimDate();
        }


        public EventosDTO() {
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
