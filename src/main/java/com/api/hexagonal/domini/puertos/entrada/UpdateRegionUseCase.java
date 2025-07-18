package com.api.hexagonal.domini.puertos.entrada;

import java.util.Optional;

import com.api.hexagonal.domini.modelo.Region;

public interface UpdateRegionUseCase {
    Optional<Region> updateRegion(Integer id, Region region);
}
