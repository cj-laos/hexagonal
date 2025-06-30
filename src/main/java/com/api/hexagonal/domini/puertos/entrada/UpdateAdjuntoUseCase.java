package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Adjunto;
import java.util.Optional;

public interface UpdateAdjuntoUseCase {
    Optional<Adjunto> updateAdjunto(Integer id, Adjunto adjunto);
}
