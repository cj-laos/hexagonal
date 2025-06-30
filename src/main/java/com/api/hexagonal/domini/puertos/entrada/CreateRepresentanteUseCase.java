package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Representante;

public interface CreateRepresentanteUseCase {
    Representante createRepresentante(Representante representante);

}
