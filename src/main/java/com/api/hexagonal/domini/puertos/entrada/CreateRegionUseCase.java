package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Region;

public interface CreateRegionUseCase {
    Region createRegion(Region region);
}
