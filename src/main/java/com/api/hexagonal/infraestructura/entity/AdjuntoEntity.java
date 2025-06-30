package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "adjuntos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdjuntoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private OngEntity ong;

    @Column(name = "url_archivo", nullable = false)
    private String urlArchivo;

    @Column
    private String descripcion;
}
