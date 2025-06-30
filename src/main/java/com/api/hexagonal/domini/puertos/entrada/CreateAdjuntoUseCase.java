package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Adjunto;

public interface CreateAdjuntoUseCase {
    Adjunto createAdjunto(Adjunto adjunto);
}
