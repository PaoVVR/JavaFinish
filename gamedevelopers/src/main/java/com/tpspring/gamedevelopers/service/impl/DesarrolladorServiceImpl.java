package com.tpspring.gamedevelopers.service.impl;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import com.tpspring.gamedevelopers.service.DesarrolladorService;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

    private DesarrolladorService desarrolladorService;

    public DesarrolladorServiceImpl(DesarrolladorService desarrolladorService) {
        this.desarrolladorService = desarrolladorService;
    }



    //Visualización de los devs de un juego: Indicado un videojuego,
    // se espera que se listen los datos del desarrollador.

        public List<Desarrollador> verDesarrolladoresDelJuego(Long idJuego) {
            List<Desarrollador> desarrolladoresDelJuego = new ArrayList<>();

            // Supongamos que la clase Desarrollador tiene un atributo "juegoId" que indica a qué juego está asociado el desarrollador
            // Aquí buscamos todos los desarrolladores cuyo "juegoId" coincide con el idJuego proporcionado
            for (Desarrollador desarrollador : listaDesarrolladores) {
                if (desarrollador.getJuegoId().equals(idJuego)) {
                    desarrolladoresDelJuego.add(desarrollador);
                }
            }

            return desarrolladoresDelJuego;
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