package com.tpspring.gamedevelopers.repository;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea,Long> {
}

