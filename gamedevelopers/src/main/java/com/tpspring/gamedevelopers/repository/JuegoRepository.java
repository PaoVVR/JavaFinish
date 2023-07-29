package com.tpspring.gamedevelopers.repository;

import com.tpspring.gamedevelopers.domain.Juego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface JuegoRepository extends JpaRepository<Juego, Long> {


    List<Juego>findByEstado(String enDesarrollo);

    List<Juego> findByEstadoEquals(String finalizado);
}

