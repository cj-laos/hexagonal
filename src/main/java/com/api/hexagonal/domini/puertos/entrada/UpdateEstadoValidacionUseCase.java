package com.api.hexagonal.domini.puertos.entrada;

public interface UpdateEstadoValidacionUseCase {
    boolean actualizarEstado(Integer id, String nuevoEstado);
}
