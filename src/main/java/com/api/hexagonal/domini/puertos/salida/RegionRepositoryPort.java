package com.api.hexagonal.domini.puertos.salida;

import java.util.*;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

public interface RegionRepositoryPort {
    RegionEntity save(RegionEntity entity);

    Optional<RegionEntity> findById(Integer id);

    void deleteById(Integer id);

    List<RegionEntity> findAll();
}
