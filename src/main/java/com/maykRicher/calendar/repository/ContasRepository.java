package com.maykRicher.calendar.repository;

import com.maykRicher.calendar.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasRepository extends JpaRepository<Contas,Integer> {

    List<Contas> findByMes(Integer mes);
}
