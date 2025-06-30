package com.api.hexagonal.domini.puertos.salida;

import java.util.*;

import com.api.hexagonal.domini.modelo.Sector;

public interface SectorRepositoryPort {
    Sector save(Sector sector);

    Optional<Sector> findById(Integer id);

    List<Sector> findAll();

    boolean deleteById(Integer id);

    boolean existsByName(String name);
}
