package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Tarea;

import java.awt.*;
import java.time.LocalDate;


public interface TareaService {
    Tarea asignarTarea(Tarea tarea);

    java.util.List<Tarea> verTareasPorDesarrollador(Long idDesarrollador);

    java.awt.List actualizarEstadoTareaEnProgreso(Tarea tarea);

    List actualizarEstadoTareaCompletada(Tarea tarea);

    List buscarTareasFueraPlazoLimite(LocalDate fechaLimite);

    List buscarTareasPorJuego(Long juegoId);


    List buscarTareasPorFechaLimite(LocalDate fechaLimite);

    List buscarTareasPorEstado(EstadoTarea estado);
}
