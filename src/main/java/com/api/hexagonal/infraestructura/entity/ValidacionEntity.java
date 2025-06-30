package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "validaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private OngEntity ong;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private UsuarioAdminEntity admin;

    @Column(name = "estado_validacion")
    private String estadoValidacion;

    private String comentario;

    @Column(name = "fecha_validacion", nullable = false)
    private LocalDateTime fechaValidacion;
}
