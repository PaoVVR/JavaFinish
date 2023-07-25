package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Juego;
import org.hibernate.mapping.List;



public interface JuegoService {

    
    Juego registroJuego(Juego juego);

    List verJuegosEnDesarrollo();

    List verJuegosFinalizados();
}
