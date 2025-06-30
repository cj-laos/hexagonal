package com.api.hexagonal.domini.puertos.salida;

import java.util.*;
import com.api.hexagonal.domini.modelo.Region;

public interface RegionRepositoryPort {
    Region save(Region region);

    Optional<Region> findById(Integer id);

    List<Region> findAll();

    boolean deleteById(Integer id);

    boolean existsByName(String name);
}
