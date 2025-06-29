package com.api.hexagonal.domini.puertos.salida;

import java.util.*;

import com.api.hexagonal.infraestructura.entity.SectorEntity;

public interface SectorRepositoryPort {
    SectorEntity save(SectorEntity entity);

    Optional<SectorEntity> findById(Integer id);

    void deleteById(Integer id);

    List<SectorEntity> findAll();
}
