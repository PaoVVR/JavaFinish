package com.tpspring.gamedevelopers.controller;

import com.tpspring.gamedevelopers.domain.Tarea;
import com.tpspring.gamedevelopers.enumeration.EstadoTarea;
import com.tpspring.gamedevelopers.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.List;
import java.time.LocalDate;


@RestController
//@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;
    private EstadoTarea estado;

    //Asignación de tareas: Permite asignar tareas a desarrolladores específicos para un juego en particular.
    // Se debe especificar la descripción de la tarea y la fecha límite.

    @PostMapping("/asignar")
    public Tarea asignarTarea(@RequestBody Tarea tarea) {
       return  tareaService.asignarTarea(tarea);
    }

   /*@PostMapping
    public ResponseEntity<Tarea> asignarTarea(@RequestParam String descripción, LocalDate fechaLimite,Tarea tarea) {
       Tarea nuevaTarea = tareaService.asignarTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }*/

    //Visualización de tareas: Permite ver todas las tareas asignadas a un desarrollador en particular,
    // incluyendo su descripción, estado y fecha límite.
    @GetMapping("/desarrollador/{desarrolladorId}")
    public List<Tarea> verTareasPorDesarrollador(@PathVariable Long desarrolladorId) {
        return tareaService.verTareasPorDesarrollador(desarrolladorId);
    }

    /*@GetMapping("/desarrollador/{idDesarrollador}")
    public ResponseEntity<List<Tarea>> verTareasPorDesarrollador(@PathVariable Long idDesarrollador) {
        List<Tarea> tareas = tareaService.verTareasPorDesarrollador(idDesarrollador);
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }*/


   // Actualización de estado de tareas: Permite marcar una tarea como completada o cambiar su estado a
   // "en progreso".

    @PutMapping("/en-progreso/{tareaId}")
    public Tarea actualizarEstadoTareaEnProgreso(@PathVariable Long tareaId) {
        return tareaService.actualizarEstadoTareaEnProgreso(tareaId);
    }

    @PutMapping("/completada/{tareaId}")
    public Tarea actualizarEstadoTareaCompletada(@PathVariable Long tareaId) {
        return tareaService.actualizarEstadoTareaCompletada(tareaId);
    }


    /*@PutMapping
    public ResponseEntity<List<Tarea>>actualizarEstadoTarea(@RequestBody Tarea tarea) {
        List<Tarea> tareasEnProgreso = tareaService.actualizarEstadoTareaEnProgreso(tarea );
        List<Tarea> tareasCompletadas = tareaService.actualizarEstadoTareaCompletada(tarea );
        return new ResponseEntity<>(tareasCompletadas,
                (MultiValueMap<String, String>)tareasEnProgreso, HttpStatus.OK);}*/



    //Búsqueda de tareas: Permite buscar tareas por estado (pendiente, en progreso, completada)
        // o por fecha límite. request param

    @GetMapping("/estado/{estado}")
    public List<Tarea> buscarTareasPorEstado(@PathVariable EstadoTarea estado) {
        this.estado = estado;
        return tareaService.buscarTareasPorEstado(estado);
    }

    @GetMapping("/fecha-limite/{fechaLimite}")
    public List<Tarea> buscarTareasPorFechaLimite(@PathVariable LocalDate fechaLimite) {
        return tareaService.buscarTareasPorFechaLimite(fechaLimite);
    }


       // Búsqueda de tareas por juego: Permite buscar tareas a partir de indicar un videojuego
       @GetMapping("/juego/{juegoId}")
       public List<Tarea> buscarTareasPorJuego(@PathVariable Long juegoId) {
           return tareaService.buscarTareasPorJuego(juegoId);
       }

       // Búsqueda de tareas fuera del plazo límite: Permite buscar tareas que no se
        // completaron en el plazo límite.
       @GetMapping("/plazo/{fechaLimite}")
       public List<Tarea> buscarTareasFueraPlazoLimite(@PathVariable LocalDate fechaLimite) {
           return tareaService.buscarTareasFueraPlazoLimite(fechaLimite);
       }
    }

