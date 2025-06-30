package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.domini.modelo.Adjunto;
import java.util.List;
import java.util.Optional;

public interface AdjuntoRepositoryPort {
    Adjunto save(Adjunto adjunto);

    Optional<Adjunto> findById(Integer id);

    List<Adjunto> findAll();

    List<Adjunto> findByOngId(Integer ongId);

    boolean deleteById(Integer id);
}
