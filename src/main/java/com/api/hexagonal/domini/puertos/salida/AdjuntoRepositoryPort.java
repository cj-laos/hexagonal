package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;
import java.util.List;
import java.util.Optional;

public interface AdjuntoRepositoryPort {
    AdjuntoEntity save(AdjuntoEntity adjunto);

    Optional<AdjuntoEntity> findById(Integer id);

    void deleteById(Integer id);

    List<AdjuntoEntity> findAll();

    List<AdjuntoEntity> findByOngId(Integer ongId);
}
