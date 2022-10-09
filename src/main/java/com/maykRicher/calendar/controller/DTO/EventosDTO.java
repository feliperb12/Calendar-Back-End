package com.maykRicher.calendar.controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maykRicher.calendar.model.Eventos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EventosDTO {

        private Integer id;
        @NotEmpty
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private String dataInicio;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private String dataFim;

//        private LocalDateTime dataInicioDate;
//
//        private LocalDateTime dataFimDate;

        public EventosDTO(Eventos obj) {
                this.dataInicio= obj.getDataInicio();
                this.dataFim= obj.getDataFim();

        }


//        public LocalDateTime getDataInicioDate() {
//                return dataInicioDate;
//        }
//
//        public void setDataInicioDate(LocalDateTime dataInicioDate) {
//                this.dataInicioDate = dataInicioDate;
//        }
//
//        public LocalDateTime getDataFimDate() {
//                return dataFimDate;
//        }
//
//        public void setDataFimDate(LocalDateTime dataFimDate) {
//                this.dataFimDate = dataFimDate;
//        }
}
