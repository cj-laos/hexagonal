package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.entrada.UpdateOngUseCase;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateOngService implements UpdateOngUseCase {

    private final OngRepositoryPort ongRepositoryPort;
    private final RepresentanteRepositoryPort representanteRepositoryPort;
    private final SectorRepositoryPort sectorRepositoryPort;
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Optional<Ong> updateOng(Integer id, Ong updatedOng) {
        return ongRepositoryPort.findById(id).map(existingOng -> {
            existingOng.setNombre(updatedOng.getNombre());
            existingOng.setFechaRegistro(updatedOng.getFechaRegistro());

            if (!existingOng.getRuc().equals(updatedOng.getRuc())) {
                if (ongRepositoryPort.existsByRuc(updatedOng.getRuc())) {
                    throw new IllegalArgumentException("El nuevo RUC ya está registrado para otra ONG.");
                }
                existingOng.setRuc(updatedOng.getRuc());
            }

            if (updatedOng.getRepresentanteId() != null
                    && !updatedOng.getRepresentanteId().equals(existingOng.getRepresentanteId())) {
                if (!representanteRepositoryPort.findById(updatedOng.getRepresentanteId()).isPresent()) {
                    throw new IllegalArgumentException(
                            "El Representante con ID " + updatedOng.getRepresentanteId() + " no existe.");
                }
                existingOng.setRepresentanteId(updatedOng.getRepresentanteId());
            }
            if (updatedOng.getSectorId() != null && !updatedOng.getSectorId().equals(existingOng.getSectorId())) {
                if (!sectorRepositoryPort.findById(updatedOng.getSectorId()).isPresent()) {
                    throw new IllegalArgumentException("El Sector con ID " + updatedOng.getSectorId() + " no existe.");
                }
                existingOng.setSectorId(updatedOng.getSectorId());
            }
            if (updatedOng.getRegionId() != null && !updatedOng.getRegionId().equals(existingOng.getRegionId())) {
                if (!regionRepositoryPort.findById(updatedOng.getRegionId()).isPresent()) {
                    throw new IllegalArgumentException("La Región con ID " + updatedOng.getRegionId() + " no existe.");
                }
                existingOng.setRegionId(updatedOng.getRegionId());
            }

            return ongRepositoryPort.save(existingOng);
        });
    }
}