package com.api.hexagonal.aplicacion.service;

import org.springframework.stereotype.Service;

import com.api.hexagonal.domini.puertos.entrada.EliminarRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteRegionService implements EliminarRegionUseCase {

    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public boolean deleteRegion(Integer id) {
        if (regionRepositoryPort.findById(id).isPresent()) {
            regionRepositoryPort.deleteById(id);
            return true;
        }
        return false;
    }

}
