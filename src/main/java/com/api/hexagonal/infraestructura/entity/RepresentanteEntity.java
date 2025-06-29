package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "representantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private LocalDate fechaNacimiento;

    private Boolean verificadoReniec = false;

    @OneToOne(mappedBy = "representante")
    private OngEntity ong;
}
