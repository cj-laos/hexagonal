package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "ongs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String ruc;

    @OneToOne
    @JoinColumn(name = "representante_id")
    private RepresentanteEntity representante;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private SectorEntity sector;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "ong")
    private List<AdjuntoEntity> adjuntos;

    @OneToMany(mappedBy = "ong")
    private List<ValidacionEntity> validaciones;
}
