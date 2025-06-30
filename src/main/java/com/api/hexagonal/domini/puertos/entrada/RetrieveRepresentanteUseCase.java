package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Representante;
import java.util.List;
import java.util.Optional;

public interface RetrieveRepresentanteUseCase {
    Optional<Representante> getRepresentanteById(Integer id);

    List<Representante> getAllRepresentantes();
}
