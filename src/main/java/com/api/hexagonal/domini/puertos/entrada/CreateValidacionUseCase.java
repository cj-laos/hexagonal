package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Validacion;

public interface CreateValidacionUseCase {
    Validacion createValidacion(Validacion validacion);
}
