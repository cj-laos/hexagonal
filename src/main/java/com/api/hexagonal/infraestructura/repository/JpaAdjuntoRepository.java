package com.api.hexagonal.infraestructura.repository;

import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAdjuntoRepository extends JpaRepository<AdjuntoEntity, Integer> {

}
