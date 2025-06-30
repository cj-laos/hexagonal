package com.api.hexagonal.infraestructura.repository;

import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjuntoRepository extends JpaRepository<AdjuntoEntity, Integer> {
    List<AdjuntoEntity> findByOngId(Integer ongId);
}
