package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteSectorUseCase;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSectorService implements DeleteSectorUseCase {
    private final SectorRepositoryPort sectorRepositoryPort;

    @Override
    public boolean deleteSector(Integer id) {
        return sectorRepositoryPort.deleteById(id);
    }
}
