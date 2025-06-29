package com.api.hexagonal.domini.puertos.entrada;

import java.util.List;
import java.util.Optional;

import com.api.hexagonal.domini.modelo.Region;

public interface ConsultarRegionUseCase {
    Optional<Region> getRegionById(Integer id);

    List<Region> getAllRegions();
}