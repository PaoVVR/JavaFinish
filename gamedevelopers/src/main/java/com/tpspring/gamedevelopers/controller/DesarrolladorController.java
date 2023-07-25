package com.tpspring.gamedevelopers.controller;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.service.DesarrolladorService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/desarrolladores")
public class DesarrolladorController {
    @Autowired
    private DesarrolladorService desarrolladorService;

//Registro de desarrolladores: Permite agregar nuevos miembros del equipo de desarrollo,
// especificando su nombre, correo electrónico y rol.
    @PostMapping
    public ResponseEntity<Desarrollador> registrarDesarrollador(@RequestBody Desarrollador desarrollador) {
        Desarrollador nuevoDesarrollador = desarrolladorService.registrarDesarrollador(desarrollador);
        return new ResponseEntity<>(nuevoDesarrollador, HttpStatus.CREATED);
    }

   //Visualización de los devs de un juego: Indicado un videojuego,
    // se espera que se listen los datos del desarrollador.

    @GetMapping("/{idJuego}")
    public ResponseEntity<List<Desarrollador>> verDesarrolladoresDelJuego(@PathVariable Long idJuego) {
        List<Desarrollador> desarrolladores = desarrolladorService.verDesarrolladoresDelJuego(idJuego);
        return new ResponseEntity<>(desarrolladores, HttpStatus.OK);
    }


    //Asignación de un desarrollador a un juego: Permitir asignar desarrolladores a un juego.
    @PostMapping
    public ResponseEntity<Desarrollador> asignarDesarrolladorAJuego(@RequestBody Desarrollador desarrollador) {
        Desarrollador nuevoDesarrollador = desarrolladorService.asignarDesarrolladorAJuego(desarrollador);
        return new ResponseEntity<>(nuevoDesarrollador, HttpStatus.CREATED);
    }
}


