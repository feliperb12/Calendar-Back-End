package com.maykRicher.calendar.controller;

import com.maykRicher.calendar.controller.DTO.EventosCreateDTO;
import com.maykRicher.calendar.controller.DTO.EventosDTO;
import com.maykRicher.calendar.controller.mapper.EventosMapper;
import com.maykRicher.calendar.model.Eventos;
import com.maykRicher.calendar.service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/eventos")
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
    @PostMapping
    public ResponseEntity<EventosDTO> create(@RequestBody @Valid EventosDTO obj) {
        Eventos newObj = service.createEvento(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventosDTO> update(@Valid @PathVariable Integer id, @RequestBody  EventosDTO obj){
        Eventos newObj = service.update(id,obj);
        return ResponseEntity.ok().body(new EventosDTO(newObj));
    }
}

