package com.tpspring.gamedevelopers.controller;

import com.tpspring.gamedevelopers.domain.Tarea;
import com.tpspring.gamedevelopers.service.TareaService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    //Asignación de tareas: Permite asignar tareas a desarrolladores específicos para un juego en particular.
    // Se debe especificar la descripción de la tarea y la fecha límite.
    @PostMapping
    public ResponseEntity<Tarea> asignarTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.asignarTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    //Visualización de tareas: Permite ver todas las tareas asignadas a un desarrollador en particular,
    // incluyendo su descripción, estado y fecha límite.
    @GetMapping("/desarrollador/{idDesarrollador}")
    public ResponseEntity<List<Tarea>> verTareasPorDesarrollador(@PathVariable Long idDesarrollador) {
        List<Tarea> tareas = tareaService.verTareasPorDesarrollador(idDesarrollador);
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }
   // Actualización de estado de tareas: Permite marcar una tarea como completada o cambiar su estado a
   // "en progreso".
    @PutMapping
    public ResponseEntity<List<Tarea>> actualizarEstadoTareas(@RequestBody Tarea tarea) {
        List<Tarea> tareas = tareaService.actualizarEstadoTarea(tarea );
        return new ResponseEntity<>(tareas, HttpStatus.OK);

        //Búsqueda de tareas: Permite buscar tareas por estado (pendiente, en progreso, completada)
        // o por fecha límite. request param


       // Búsqueda de tareas por juego: Permite buscar tareas a partir de indicar un videojuego


       // Búsqueda de tareas fuera del plazo límite: Permite buscar tareas que no se
        // completaron en el plazo límite.

    }

}
