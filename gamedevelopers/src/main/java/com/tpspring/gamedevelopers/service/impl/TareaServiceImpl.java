package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.domain.Tarea;
import com.tpspring.gamedevelopers.enumeration.EstadoTarea;
import com.tpspring.gamedevelopers.repository.DesarrolladorRepository;
import com.tpspring.gamedevelopers.repository.JuegoRepository;
import com.tpspring.gamedevelopers.repository.TareaRepository;
import com.tpspring.gamedevelopers.service.TareaService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.List;
import java.time.LocalDate;

@Transactional
@Service
public class TareaServiceImpl implements TareaService {
    private final JuegoRepository juegoRepository;
    private final DesarrolladorRepository desarrolladorRepository;
    private final TareaRepository tareaRepository;

    public TareaServiceImpl(JuegoRepository juegoRepository, DesarrolladorRepository desarrolladorRepository, TareaRepository tareaRepository) {
        this.juegoRepository = juegoRepository;
        this.desarrolladorRepository = desarrolladorRepository;
        this.tareaRepository = tareaRepository;
    }


    //Asignación de tareas: Permite asignar tareas a desarrolladores específicos para un juego en particular.
    // Se debe especificar la descripción de la tarea y la fecha límite.

    @Override
    public Tarea asignarTarea(Tarea tarea) {
        Desarrollador desarrollador = desarrolladorRepository.findById(desarrolladorRepository.count()).orElseThrow(() -> new RuntimeException("Desarrollador no encontrado"));
        desarrollador.getRol().add(tarea.getJuego());
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setDescripcion(tarea.getDescripcion());
        nuevaTarea.setFechaLimite(tarea.getFechaLimite());

        return tareaRepository.save(tarea);
    }

    //Visualización de tareas: Permite ver todas las tareas asignadas a un desarrollador en particular,
    // incluyendo su descripción, estado y fecha límite.

    @Override
    public java.util.List<Tarea> verTareasPorDesarrollador(Long desarrolladorId) {
            Desarrollador desarrollador = desarrolladorRepository.findById(desarrolladorId)
                    .orElseThrow(() -> new RuntimeException("Desarrollador no encontrado"));

            return tareaRepository.findByDesarrollador(desarrollador);}




    // Actualización de estado de tareas: Permite marcar una tarea como completada o cambiar su estado a
    // "en progreso".

    public Tarea actualizarEstadoTareaEnProgreso(Long tareaId) {
        Tarea tarea = tareaRepository.findById(tareaId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        tarea.setEstado(EstadoTarea.EN_PROGRESO);
        return tareaRepository.save(tarea);
    }
    public Tarea actualizarEstadoTareaCompletada(Long tareaId) {
        Tarea tarea = tareaRepository.findById(tareaId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        tarea.setEstado(EstadoTarea.COMPLETADA);
        return tareaRepository.save(tarea);
    }


    //Búsqueda de tareas: Permite buscar tareas por estado (pendiente, en progreso, completada)
    // o por fecha límite. Request param

   public List<Tarea> buscarTareasPorEstado(EstadoTarea estado) {
        return (List<Tarea>) tareaRepository.findByEstado(estado);
    }

    public List<Tarea> buscarTareasPorFechaLimite(LocalDate fechaLimite) {
        return (List<Tarea>) tareaRepository.findByFechaLimite(fechaLimite);
    }

    // Búsqueda de tareas por juego: Permite buscar tareas a partir de indicar un videojuego
    public List<Tarea> buscarTareasPorJuego(Long juegoId) {
        Juego juego = juegoRepository.findById(juegoId)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));

        return tareaRepository.findByJuego(juego);
    }


    // Búsqueda de tareas fuera del plazo límite: Permite buscar tareas que no se
    // completaron en el plazo límite.

    public List<Tarea> buscarTareasFueraPlazoLimite(LocalDate fechaLimite) {
        EstadoTarea completada = EstadoTarea.COMPLETADA;
        return tareaRepository.findByFechaLimiteBeforeAndEstadoNot(fechaLimite, completada);
    }
        }
