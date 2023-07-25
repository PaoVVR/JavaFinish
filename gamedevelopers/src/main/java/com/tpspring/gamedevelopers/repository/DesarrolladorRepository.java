package com.tpspring.gamedevelopers.repository;

import com.tpspring.gamedevelopers.domain.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {

}