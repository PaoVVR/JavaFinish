package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.repository.DesarrolladorRepository;
import com.tpspring.gamedevelopers.repository.JuegoRepository;
import com.tpspring.gamedevelopers.service.DesarrolladorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Desarrollador nuevoDesarrollador = new Desarrollador();
        nuevoDesarrollador.setNombre(desarrollador.getNombre());
        nuevoDesarrollador.setCorreoElectronico(desarrollador.getCorreoElectronico());
        nuevoDesarrollador.setRol(desarrollador.getRol());
        return desarrolladorRepository.save(nuevoDesarrollador);
    }


    //Asignación de un desarrollador a un juego: Permitir asignar desarrolladores a un juego.
    @Transactional
    @Override
    public Desarrollador asignarDesarrolladorAJuego(Desarrollador desarrollador) {
            Juego juego = juegoRepository.findById(juegoRepository.count()).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
            juego.getDesarrolladores().add(desarrollador);
            desarrollador.getRol().add(juego);

            juegoRepository.save(juego);

        return null;
    }
}