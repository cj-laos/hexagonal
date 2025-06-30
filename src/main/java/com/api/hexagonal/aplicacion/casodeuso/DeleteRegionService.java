package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRegionService implements DeleteRegionUseCase {
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public boolean deleteRegion(Integer id) {
        return regionRepositoryPort.deleteById(id);
    }
}
