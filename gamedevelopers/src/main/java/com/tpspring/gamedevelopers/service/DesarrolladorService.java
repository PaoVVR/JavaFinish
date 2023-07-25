package com.tpspring.gamedevelopers.service;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import org.hibernate.mapping.List;



public interface DesarrolladorService {
  
    List verDesarrolladoresDelJuego(Long idJuego);

    Desarrollador registrarDesarrollador(Desarrollador desarrollador);

    Desarrollador asignarDesarrolladorAJuego(Desarrollador desarrollador);
}
