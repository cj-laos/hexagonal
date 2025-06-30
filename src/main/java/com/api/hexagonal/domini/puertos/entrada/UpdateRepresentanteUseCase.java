package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Representante;
import java.util.Optional;

public interface UpdateRepresentanteUseCase {
    Optional<Representante> updateRepresentante(Integer id, Representante representante);
}
