package com.tpspring.gamedevelopers.domain;

import com.tpspring.gamedevelopers.enumeration.EstadoTarea;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarea {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private List<Desarrollador> desarrolladores = new ArrayList<>();

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private List<Juego> juegos = new ArrayList<>();

    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoTarea estado;


    private LocalDate fechaLimite;

    @ManyToOne
    private Juego juego;

    @ManyToOne
    private Desarrollador desarrollador;

}

