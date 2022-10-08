package com.maykRicher.calendar.repository;

import com.maykRicher.calendar.model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos,Integer> {
}
