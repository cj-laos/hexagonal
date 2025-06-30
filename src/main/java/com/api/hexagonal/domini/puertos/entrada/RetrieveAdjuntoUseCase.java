package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Adjunto;
import java.util.List;
import java.util.Optional;

public interface RetrieveAdjuntoUseCase {
    Optional<Adjunto> getAdjuntoById(Integer id);

    List<Adjunto> getAllAdjuntos();

    List<Adjunto> getAdjuntosByOngId(Integer ongId);
}