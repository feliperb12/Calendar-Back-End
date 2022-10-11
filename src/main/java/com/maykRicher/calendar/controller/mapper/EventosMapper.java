package com.maykRicher.calendar.controller.mapper;

import com.maykRicher.calendar.controller.DTO.EventosCreateDTO;
import com.maykRicher.calendar.controller.DTO.EventosDTO;
import com.maykRicher.calendar.model.Eventos;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EventosMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Eventos toEventosCreate(EventosCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Eventos.class);
    }



    public EventosDTO toEventosDTO (Eventos pessoa) {
        return MODEL_MAPPER.map(pessoa,EventosDTO.class);
    }
}
