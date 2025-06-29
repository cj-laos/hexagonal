package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.infraestructura.entity.ValidacionEntity;
import java.util.List;
import java.util.Optional;

public interface ValidacionRepositoryPort {
    ValidacionEntity save(ValidacionEntity validacion);

    Optional<ValidacionEntity> findById(Integer id);

    void deleteById(Integer id);

    List<ValidacionEntity> findAll();

    List<ValidacionEntity> findByOngId(Integer ongId);
}
