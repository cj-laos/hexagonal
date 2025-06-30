package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.UpdateRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateRegionService implements UpdateRegionUseCase {
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Optional<Region> updateRegion(Integer id, Region updatedRegion) {
        return regionRepositoryPort.findById(id).map(existingRegion -> {
            if (!existingRegion.getNombre().equals(updatedRegion.getNombre())) {
                if (regionRepositoryPort.existsByName(updatedRegion.getNombre())) {
                    throw new IllegalArgumentException(
                            "El nuevo nombre de región ya existe: " + updatedRegion.getNombre());
                }
                existingRegion.setNombre(updatedRegion.getNombre());
            }
            return regionRepositoryPort.save(existingRegion);
        });
    }
}
