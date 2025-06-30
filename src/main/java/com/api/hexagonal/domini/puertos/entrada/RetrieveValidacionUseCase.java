package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Validacion;
import java.util.List;
import java.util.Optional;

public interface RetrieveValidacionUseCase {
    Optional<Validacion> getValidacionById(Integer id);

    List<Validacion> getAllValidaciones();

    List<Validacion> getValidacionesByOngId(Integer ongId);
}
