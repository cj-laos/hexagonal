package com.api.hexagonal.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hexagonal.infraestructura.entity.SectorEntity;

public interface SectorRepository extends JpaRepository<SectorEntity, Integer> {
    boolean existsByNombre(String nombre);
}
