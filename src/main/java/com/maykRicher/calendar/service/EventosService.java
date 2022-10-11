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

    public Eventos createEvento(EventosDTO objDTO){
        return repository.save(new Eventos(null,
                objDTO.getDataInicio(),
                objDTO.getDataFim()));
    }

    public void delete(Integer idObj){
        repository.findById(idObj);
        repository.deleteById(idObj);
    }

    public Eventos update(Integer id, EventosDTO objDTO){
        Eventos obj= findById(id);
        obj.setDataInicio(objDTO.getDataInicio());
        obj.setDataFim(objDTO.getDataFim());
        return repository.save(obj);
    }




}
