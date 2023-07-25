package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Juego;
import com.tpspring.gamedevelopers.repository.JuegoRepository;
import com.tpspring.gamedevelopers.repository.JuegoRepositoryFinish;
import com.tpspring.gamedevelopers.service.JuegoService;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Juego registroJuego(String titulo, String descripcion, LocalDate fechaLanzamiento) {
        Juego nuevoJuego = new Juego();
        nuevoJuego.setTitulo(titulo);
        nuevoJuego.setDescripcion(descripcion);
        nuevoJuego.setFechaLanzamiento(fechaLanzamiento);

        return juegoRepository.save(nuevoJuego);
    }


    //Visualización de juegos finalizados: Permite listar los juegos que terminaron su desarrollo.

    public List<Juego> verJuegosFinalizados() {
        return JuegoRepositoryFinish.findByEstado("Finalizado");
    }

}
