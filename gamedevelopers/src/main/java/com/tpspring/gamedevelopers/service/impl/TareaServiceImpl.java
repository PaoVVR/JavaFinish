package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Tarea;
import com.tpspring.gamedevelopers.service.TareaService;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl implements TareaService {
    @Override
    public Tarea asignarTarea(Tarea tarea) {
        return null;
    }

    @Override
    public List verTareasPorDesarrollador(Long idDesarrollador) {
        return null;
    }

    @Override
    public List actualizarEstadoTarea(Tarea tarea) {
        return null;
    }
}
