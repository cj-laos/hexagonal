package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.domini.puertos.entrada.CreateAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAdjuntoService implements CreateAdjuntoUseCase {

    private final AdjuntoRepositoryPort adjuntoRepositoryPort;
    private final OngRepositoryPort ongRepositoryPort;

    @Override
    public Adjunto createAdjunto(Adjunto adjunto) {
        if (adjunto.getOngId() != null && !ongRepositoryPort.findById(adjunto.getOngId()).isPresent()) {
            throw new IllegalArgumentException("La ONG con ID " + adjunto.getOngId() + " no existe.");
        }
        return adjuntoRepositoryPort.save(adjunto);
    }
}