package com.api.hexagonal.infraestructura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;

public interface RepresentanteRepository extends JpaRepository<RepresentanteEntity, Integer> {
    Optional<RepresentanteEntity> findByDni(String dni);

    boolean existsByDni(String dni);
}
