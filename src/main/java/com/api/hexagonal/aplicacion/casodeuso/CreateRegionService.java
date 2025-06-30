package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.CreateRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRegionService implements CreateRegionUseCase {
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Region createRegion(Region region) {
        if (regionRepositoryPort.existsByName(region.getNombre())) {
            throw new IllegalArgumentException("Ya existe una región con el nombre: " + region.getNombre());
        }
        return regionRepositoryPort.save(region);
    }
}
