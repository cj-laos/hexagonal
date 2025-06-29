package com.api.hexagonal.infraestructura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;

public interface JpaAdminRepository extends JpaRepository<UsuarioAdminEntity, Integer> {
    Optional<UsuarioAdminEntity> findByEmail(String email);
}
