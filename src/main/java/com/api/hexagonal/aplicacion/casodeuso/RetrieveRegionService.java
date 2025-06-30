package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveRegionService implements RetrieveRegionUseCase {
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Optional<Region> getRegionById(Integer id) {
        return regionRepositoryPort.findById(id);
    }

    @Override
    public List<Region> getAllRegions() {
        return regionRepositoryPort.findAll();
    }
}
