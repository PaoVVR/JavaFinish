package com.tpspring.gamedevelopers.controller;

import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/juegos")
public class JuegoController {
    @Autowired
    private JuegoService juegoService;
    private Juego juego; }

    //Registro de juegos: Permite agregar nuevos juegos al sistema,
    // especificando su título, descripción y fecha de lanzamiento.
    /*@PostMapping
    public ResponseEntity<Juego> registroJuego(@RequestParam String titulo, String descripcion, LocalDate fechaLanzamiento) {
        Juego nuevoJuego = juegoService.registroJuego(juego);
        return new ResponseEntity<>(nuevoJuego, HttpStatus.CREATED);
    }

    //Visualización de juegos: Permite listar los juegos que se están desarrollando.
    @GetMapping
    public ResponseEntity<List<Juego>> verJuegosEnDesarrollo() {
        List<Juego> juegosEnDesarrollo = juegoService.verJuegosEnDesarrollo();
        return new ResponseEntity<>(juegosEnDesarrollo, HttpStatus.OK);
    }

    //Visualización de juegos finalizados: Permite listar los juegos que terminaron su desarrollo.
    @GetMapping("/finalizados")
    public ResponseEntity<List<Juego>> verJuegosFinalizados() {
        List<Juego> juegosFinalizados = juegoService.verJuegosFinalizados();
        return new ResponseEntity<>(juegosFinalizados, HttpStatus.OK);
    }

    }
*/
