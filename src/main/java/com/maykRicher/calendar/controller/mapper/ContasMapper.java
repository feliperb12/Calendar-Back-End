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
public class ContasMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Contas toContasCreate(ContasCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Contas.class);
    }

    public List<ContasDTO> toContasDTOList(List<Contas> contasList) {
        return contasList.stream().map(this::toContasDTO).collect(Collectors.toList());
    }
    public ContasDTO toContasDTO (Contas contas) {
        return MODEL_MAPPER.map(contas,ContasDTO.class);
    }
}
