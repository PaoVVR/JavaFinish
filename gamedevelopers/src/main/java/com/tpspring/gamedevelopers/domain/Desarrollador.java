package com.tpspring.gamedevelopers.domain;

import com.tpspring.gamedevelopers.enumeration.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Desarrollador {
    @ManyToMany(mappedBy = "desarrolladores")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String nombre;

    @Column(length = 50,columnDefinition = "varchar(50)",updatable = true,nullable = false)
    private String correoElectronico;

    @Enumerated(EnumType.STRING)
    private Rol rol;

 }



