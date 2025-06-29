package com.api.hexagonal.domini.puertos.salida;

import java.util.*;

import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;

public interface RepresentanteRepositoryPort {
    RepresentanteEntity save(RepresentanteEntity entity);

    Optional<RepresentanteEntity> findById(Integer id);

    void deleteById(Integer id);

    List<RepresentanteEntity> findAll();
}
