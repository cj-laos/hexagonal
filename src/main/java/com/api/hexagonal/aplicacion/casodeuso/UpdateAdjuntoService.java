package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.domini.puertos.entrada.UpdateAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort; // Para validar si la ONG existe
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateAdjuntoService implements UpdateAdjuntoUseCase {

    private final AdjuntoRepositoryPort adjuntoRepositoryPort;
    private final OngRepositoryPort ongRepositoryPort;

    @Override
    public Optional<Adjunto> updateAdjunto(Integer id, Adjunto updatedAdjunto) {
        return adjuntoRepositoryPort.findById(id).map(existingAdjunto -> {
            existingAdjunto.setUrlArchivo(updatedAdjunto.getUrlArchivo());
            existingAdjunto.setDescripcion(updatedAdjunto.getDescripcion());

            if (updatedAdjunto.getOngId() != null && !updatedAdjunto.getOngId().equals(existingAdjunto.getOngId())) {
                if (!ongRepositoryPort.findById(updatedAdjunto.getOngId()).isPresent()) {
                    throw new IllegalArgumentException(
                            "La nueva ONG con ID " + updatedAdjunto.getOngId() + " no existe.");
                }
                existingAdjunto.setOngId(updatedAdjunto.getOngId());
            }

            return adjuntoRepositoryPort.save(existingAdjunto);
        });
    }
}