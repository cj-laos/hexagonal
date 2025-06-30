package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.domini.puertos.entrada.CreateSectorUseCase;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSectorService implements CreateSectorUseCase {
    private final SectorRepositoryPort sectorRepositoryPort;

    @Override
    public Sector createSector(Sector sector) {
        if (sectorRepositoryPort.existsByName(sector.getNombre())) {
            throw new IllegalArgumentException("Ya existe un sector con el nombre: " + sector.getNombre());
        }
        return sectorRepositoryPort.save(sector);
    }
}
