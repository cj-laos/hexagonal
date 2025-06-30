package com.api.hexagonal.infraestructura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hexagonal.infraestructura.entity.OngEntity;

public interface OngRepository extends JpaRepository<OngEntity, Integer> {
    Optional<OngEntity> findByRuc(String ruc);

    boolean existsByRuc(String ruc);
}
