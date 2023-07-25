package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Desarrollador;

import java.util.List;


public interface DesarrolladorService {

    List<Desarrollador> verDesarrolladoresDelJuego(Long idJuego);
    Desarrollador registrarDesarrollador(Desarrollador desarrollador);

    Desarrollador asignarDesarrolladorAJuego(Desarrollador desarrollador);
}