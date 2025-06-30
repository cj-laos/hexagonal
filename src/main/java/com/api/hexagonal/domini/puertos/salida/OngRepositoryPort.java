package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.domini.modelo.Ong;
import java.util.List;
import java.util.Optional;

public interface OngRepositoryPort {
    Ong save(Ong ong);

    Optional<Ong> findById(Integer id);

    Optional<Ong> findByRuc(String ruc);

    List<Ong> findAll();

    boolean deleteById(Integer id);

    boolean existsByRuc(String ruc);
}
