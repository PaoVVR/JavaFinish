package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Tarea;
import org.hibernate.mapping.List;



public interface TareaService {
    Tarea asignarTarea(Tarea tarea);

    List verTareasPorDesarrollador(Long idDesarrollador);

    List actualizarEstadoTarea(Tarea tarea);
}
