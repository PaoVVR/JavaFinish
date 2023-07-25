package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.repository.DesarrolladorRepository;
import com.tpspring.gamedevelopers.repository.JuegoRepository;
import com.tpspring.gamedevelopers.service.DesarrolladorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

    private final DesarrolladorRepository desarrolladorRepository;

    private final JuegoRepository juegoRepository;

    public DesarrolladorServiceImpl(DesarrolladorRepository desarrolladorRepository, JuegoRepository juegoRepository) {
        this.desarrolladorRepository = desarrolladorRepository;
        this.juegoRepository = juegoRepository;
    }


    //Visualización de los devs de un juego: Indicado un videojuego,
    // se espera que se listen los datos del desarrollador.


    @Override
    public List<Desarrollador> verDesarrolladoresDelJuego(Long idJuego) {
        Optional<Juego> juego = juegoRepository.findById(idJuego);
        return juego.get().getDesarrolladores();
    }

    //Registro de desarrolladores: Permite agregar nuevos miembros del equipo de desarrollo,
    // especificando su nombre, correo electrónico y rol.
    @Override
    public Desarrollador registrarDesarrollador(Desarrollador desarrollador) {
        return null;
    }


    //Asignación de un desarrollador a un juego: Permitir asignar desarrolladores a un juego.
    @Override
    public Desarrollador asignarDesarrolladorAJuego(Desarrollador desarrollador) {
        return null;
    }
}