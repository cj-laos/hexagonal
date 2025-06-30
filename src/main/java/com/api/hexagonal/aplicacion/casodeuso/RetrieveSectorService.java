package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.domini.puertos.entrada.RetrieveSectorUseCase;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveSectorService implements RetrieveSectorUseCase {
    private final SectorRepositoryPort sectorRepositoryPort;

    @Override
    public Optional<Sector> getSectorById(Integer id) {
        return sectorRepositoryPort.findById(id);
    }

    @Override
    public List<Sector> getAllSectors() {
        return sectorRepositoryPort.findAll();
    }
}
