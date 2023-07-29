package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.repository.JuegoRepository;
import com.tpspring.gamedevelopers.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService {
    private final JuegoRepository juegoRepository;

    // Constructor para la inyección de dependencias del repositorio
    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    //Visualización de juegos: Permite listar los juegos que se están desarrollando.
    public List<Juego> verJuegosEnDesarrollo() {

        return juegoRepository.findByEstado("En Desarrollo");
    }

    //Registro de juegos: Permite agregar nuevos juegos al sistema,
    // especificando su título, descripción y fecha de lanzamiento.
    public Juego registroJuego(Juego juego) {
        Juego nuevoJuego = new Juego();
        nuevoJuego.setTitulo(juego.getTitulo());
        nuevoJuego.setDescripcion(juego.getDescripcion());
        nuevoJuego.setFechaLanzamiento(juego.getFechaLanzamiento());

        return juegoRepository.save(nuevoJuego);
    }


    //Visualización de juegos finalizados: Permite listar los juegos que terminaron su desarrollo.
    public List<Juego> verJuegosFinalizados() {
        return juegoRepository.findByEstadoEquals("Finalizado");
    }


}
