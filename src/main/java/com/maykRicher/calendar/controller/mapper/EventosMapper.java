package com.maykRicher.calendar.controller.mapper;

import com.maykRicher.calendar.controller.DTO.ContasCreateDTO;
import com.maykRicher.calendar.controller.DTO.ContasDTO;
import com.maykRicher.calendar.controller.DTO.EventosCreateDTO;
import com.maykRicher.calendar.controller.DTO.EventosDTO;
import com.maykRicher.calendar.model.Contas;
import com.maykRicher.calendar.model.Eventos;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventosMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Eventos toEventosCreate(EventosDTO dto) {
        return MODEL_MAPPER.map(dto, Eventos.class);
    }

    public List<EventosDTO> toEventosDTOList(List<Eventos> contasList) {
        return contasList.stream().map(this::toEventosDTO).collect(Collectors.toList());
    }
    public EventosDTO toEventosDTO (Eventos eventos) {
        return MODEL_MAPPER.map(eventos,EventosDTO.class);
    }
}
