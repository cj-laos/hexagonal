package com.api.hexagonal.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {
    boolean existsByNombre(String nombre);
}
