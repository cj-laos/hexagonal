package com.api.hexagonal.domini.puertos.salida;

import java.util.*;

import com.api.hexagonal.domini.modelo.Representante;

public interface RepresentanteRepositoryPort {
    Representante save(Representante representante);

    Optional<Representante> findById(Integer id);

    Optional<Representante> findByDni(String dni);

    List<Representante> findAll();

    boolean deleteById(Integer id);

    boolean existsByDni(String dni);
}
