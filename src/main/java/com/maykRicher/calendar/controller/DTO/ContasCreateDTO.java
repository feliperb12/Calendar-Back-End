package com.maykRicher.calendar.controller.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ContasCreateDTO {


    private String descricao;

    private float valor;
    @NotEmpty
    private String dataDaConta;
}
