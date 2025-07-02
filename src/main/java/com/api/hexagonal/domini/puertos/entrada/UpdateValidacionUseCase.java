package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Validacion;
import java.util.Optional;

public interface UpdateValidacionUseCase {
    Optional<Validacion> updateValidacion(Integer id, Validacion validacion);

    boolean actualizarEstado(Integer id, String estadoValidacion, Integer adminId); // ← actualiza la firma

}
