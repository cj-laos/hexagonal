package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "region")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "region")
    private List<OngEntity> ongs;
}
