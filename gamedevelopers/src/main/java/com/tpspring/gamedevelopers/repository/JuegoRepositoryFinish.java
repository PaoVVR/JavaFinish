package com.tpspring.gamedevelopers.repository;

import com.tpspring.gamedevelopers.domain.Juego;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositoryFinish extends JpaRepository<Juego, Long> {
   List findByEstado(String Finalizado);

}
