package com.maykRicher.calendar.service;

import com.maykRicher.calendar.exception.ContasNotFoundException;
import com.maykRicher.calendar.model.Contas;
import com.maykRicher.calendar.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContasService {

    @Autowired
    private ContasRepository repository;


    public Contas create(Contas contasCreate) {
        Integer mes = Integer.parseInt(contasCreate.getDataDaConta().substring(3,5));
        contasCreate.setMes(mes);
        repository.save(contasCreate);
        return contasCreate;
    }

    public Contas findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ContasNotFoundException(id));
    }

    public List<Contas> findAll() {
        return repository.findAll();
    }

    public List<Contas> findByMes(Integer mes) {
        return repository.findByMes(mes);
    }

    public Float valoresConta(Integer id) {
        List<Contas> contas = findByMes(id);
        float valor = 0;
        for (Contas conta: contas){
            valor += conta.getValor();
        }
        return valor;
    }


    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public Contas update(Integer id, Contas contaCreate) {
        Contas conta = findById(id);


        conta.setDescricao(contaCreate.getDescricao());
        conta.setValor(contaCreate.getValor());
        conta.setDataDaConta(contaCreate.getDataDaConta());
        conta.setMes(Integer.parseInt(contaCreate.getDataDaConta().substring(3,5)));

        repository.save(conta);
        return conta;
    }


}
