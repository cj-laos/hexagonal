package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.domini.puertos.entrada.RetrieveAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveAdjuntoService implements RetrieveAdjuntoUseCase {

    private final AdjuntoRepositoryPort adjuntoRepositoryPort;

    @Override
    public Optional<Adjunto> getAdjuntoById(Integer id) {
        return adjuntoRepositoryPort.findById(id);
    }

    @Override
    public List<Adjunto> getAllAdjuntos() {
        return adjuntoRepositoryPort.findAll();
    }

    @Override
    public List<Adjunto> getAdjuntosByOngId(Integer ongId) {
        return adjuntoRepositoryPort.findByOngId(ongId);
    }
}
