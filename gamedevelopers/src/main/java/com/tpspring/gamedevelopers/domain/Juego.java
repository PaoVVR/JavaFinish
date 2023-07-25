package com.tpspring.gamedevelopers.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Juego {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String titulo;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String descripcion;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String desarrolladores;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String tareas;

    private LocalDate fechaLanzamiento;

}
