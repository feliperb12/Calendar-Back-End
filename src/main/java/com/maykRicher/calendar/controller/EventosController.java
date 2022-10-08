package com.maykRicher.calendar.controller;

import com.maykRicher.calendar.controller.DTO.EventosDTO;
import com.maykRicher.calendar.model.Eventos;
import com.maykRicher.calendar.service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping("/eventos")
public class EventosController {
    @Autowired
    private EventosService service;

    @GetMapping("/{id}")
    public ResponseEntity<Eventos> findById(@PathVariable Integer id){
        Eventos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<EventosDTO>> findAll(){
        List<Eventos> list = service.findAll();
        List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}