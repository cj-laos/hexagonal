package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "sectores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "sector")
    private List<OngEntity> ongs;
}
