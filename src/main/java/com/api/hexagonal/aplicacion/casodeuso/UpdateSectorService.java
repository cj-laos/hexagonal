package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.domini.puertos.entrada.UpdateSectorUseCase;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateSectorService implements UpdateSectorUseCase {
    private final SectorRepositoryPort sectorRepositoryPort;

    @Override
    public Optional<Sector> updateSector(Integer id, Sector updatedSector) {
        return sectorRepositoryPort.findById(id).map(existingSector -> {
            if (!existingSector.getNombre().equals(updatedSector.getNombre())) {
                if (sectorRepositoryPort.existsByName(updatedSector.getNombre())) {
                    throw new IllegalArgumentException(
                            "El nuevo nombre de sector ya existe: " + updatedSector.getNombre());
                }
                existingSector.setNombre(updatedSector.getNombre());
            }
            return sectorRepositoryPort.save(existingSector);
        });
    }
}
