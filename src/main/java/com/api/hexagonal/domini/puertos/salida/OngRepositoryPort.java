package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.infraestructura.entity.OngEntity;
import java.util.List;
import java.util.Optional;

public interface OngRepositoryPort {
    OngEntity save(OngEntity ong);

    Optional<OngEntity> findById(Integer id);

    Optional<OngEntity> findByRuc(String ruc);

    void deleteById(Integer id);

    List<OngEntity> findAll();
}
