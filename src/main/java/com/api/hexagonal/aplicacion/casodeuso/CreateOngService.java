package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.entrada.CreateOngUseCase;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateOngService implements CreateOngUseCase {

    private final OngRepositoryPort ongRepositoryPort;
    private final RepresentanteRepositoryPort representanteRepositoryPort;
    private final SectorRepositoryPort sectorRepositoryPort;
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Ong createOng(Ong ong) {
        if (ongRepositoryPort.existsByRuc(ong.getRuc())) {
            throw new IllegalArgumentException("Ya existe una ONG con el RUC: " + ong.getRuc());
        }

        if (ong.getRepresentanteId() != null &&
                !representanteRepositoryPort.findByDni(ong.getRepresentanteId().toString()).isPresent()) {
            throw new IllegalArgumentException("El Representante con DNI " + ong.getRepresentanteId() + " no existe.");
        }

        if (ong.getSectorId() != null && !sectorRepositoryPort.findById(ong.getSectorId()).isPresent()) {
            throw new IllegalArgumentException("El Sector con ID " + ong.getSectorId() + " no existe.");
        }
        if (ong.getRegionId() != null && !regionRepositoryPort.findById(ong.getRegionId()).isPresent()) {
            throw new IllegalArgumentException("La Región con ID " + ong.getRegionId() + " no existe.");
        }

        if (ong.getFechaRegistro() == null) {
            ong.setFechaRegistro(LocalDateTime.now());
        }

        return ongRepositoryPort.save(ong);
    }
}