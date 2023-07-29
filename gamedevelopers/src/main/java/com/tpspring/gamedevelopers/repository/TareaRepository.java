package com.tpspring.gamedevelopers.repository;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.domain.Tarea;
import com.tpspring.gamedevelopers.enumeration.EstadoTarea;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.time.LocalDate;

public interface TareaRepository extends JpaRepository<Tarea,Long> {
    java.util.List <Tarea> findByDesarrollador(Desarrollador desarrollador);
    java.util.List<Tarea> findByEstado(EstadoTarea estado);
    java.util.List<Tarea> findByFechaLimite(LocalDate fechaLimite);

    List findByJuego(Juego juego);

    List findByFechaLimiteBeforeAndEstadoNot(LocalDate fechaLimite, EstadoTarea completada);
}

