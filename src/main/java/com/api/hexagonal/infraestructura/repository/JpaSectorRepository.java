package com.api.hexagonal.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hexagonal.infraestructura.entity.SectorEntity;

public interface JpaSectorRepository extends JpaRepository<SectorEntity, Integer> {

}
