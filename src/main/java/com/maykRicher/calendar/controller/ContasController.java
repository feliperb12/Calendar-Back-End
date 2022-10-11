package com.maykRicher.calendar.controller;

import com.maykRicher.calendar.controller.DTO.ContasCreateDTO;
import com.maykRicher.calendar.controller.DTO.ContasDTO;
import com.maykRicher.calendar.controller.mapper.ContasMapper;
import com.maykRicher.calendar.model.Contas;
import com.maykRicher.calendar.repository.ContasRepository;
import com.maykRicher.calendar.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;

    @Autowired
    private ContasRepository repository;

    @Autowired
    private ContasMapper contasMapper;


    @PostMapping
    public ResponseEntity<ContasDTO> create(@RequestBody ContasCreateDTO dto) {
        var contasCreate = contasMapper.toContasCreate(dto);
        var conta = contasService.create(contasCreate);
        var result = contasMapper.toContasDTO(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/")
    public ResponseEntity<List<ContasDTO>> findAll() {
            List<Contas> contasList = contasService.findAll();
            List<ContasDTO> result = contasMapper.toContasDTOList(contasList);
            return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContasDTO> findById(@PathVariable Integer id) {
        Contas contas = contasService.findById(id);
        ContasDTO contasDTO = contasMapper.toContasDTO(contas);
        return ResponseEntity.ok(contasDTO);
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<ContasDTO>> findByMes(@RequestParam("mes") Integer mes) {
        List<Contas> contasList = contasService.findByMes(mes);
        List<ContasDTO> result = contasMapper.toContasDTOList(contasList);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContasDTO> update(@PathVariable Integer id, @RequestBody @Valid ContasCreateDTO contasCreateDTO) {
        Contas contasUpdate = contasMapper.toContasCreate(contasCreateDTO);
        Contas contas = contasService.update(id, contasUpdate);
        return ResponseEntity.ok(contasMapper.toContasDTO(contas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        contasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
