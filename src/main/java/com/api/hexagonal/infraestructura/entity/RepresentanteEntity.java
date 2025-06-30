package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "verificado_reniec", columnDefinition = "boolean default false")
    private Boolean verificadoReniec;

    @OneToMany(mappedBy = "representante", fetch = FetchType.LAZY)
    private List<OngEntity> ongs;
}
