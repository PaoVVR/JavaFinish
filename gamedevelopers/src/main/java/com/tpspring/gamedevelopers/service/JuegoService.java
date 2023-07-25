package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Juego;

import java.util.List;

public interface JuegoService {
    
    Juego registroJuego(Juego juego);

    List<Juego> verJuegosEnDesarrollo();

    List<Juego> verJuegosFinalizados();
}
