package com.api.hexagonal.domini.puertos.salida;

import com.api.hexagonal.domini.modelo.Validacion;
import java.util.List;
import java.util.Optional;

public interface ValidacionRepositoryPort {
    Validacion save(Validacion validacion);

    Optional<Validacion> findById(Integer id);

    List<Validacion> findAll();

    List<Validacion> findByOngId(Integer ongId);

    boolean deleteById(Integer id);
}
