package com.maykRicher.calendar.service;

import com.maykRicher.calendar.controller.DTO.EventosDTO;
import com.maykRicher.calendar.exception.EventoNotFoundException;
import com.maykRicher.calendar.model.Eventos;
import com.maykRicher.calendar.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventosService {

    @Autowired
    private EventosRepository repository;


    public Eventos findById(Integer id){
        Optional<Eventos> obj = repository.findById(id);
        return obj.orElseThrow(()-> new EventoNotFoundException(id));
    }
    public List<Eventos> findAll(){
        return repository.findAll();
    }

    public Eventos create(Eventos objDTO){
        return repository.save(objDTO);
    }

    public void delete(Integer idObj){
        repository.findById(idObj);
        repository.deleteById(idObj);
    }

    public Eventos update(Integer id, Eventos objDTO){
        Eventos obj= findById(id);
        obj.setTitle(objDTO.getTitle());
        obj.setStart(objDTO.getStart());
        return repository.save(obj);
    }




}