package com.api.hexagonal.infraestructura.entity;

import lombok.*;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "pass")
    private String password;

    @OneToMany(mappedBy = "admin")
    private List<ValidacionEntity> validaciones;
}