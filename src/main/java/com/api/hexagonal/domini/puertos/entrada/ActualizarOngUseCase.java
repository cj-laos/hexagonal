package com.api.hexagonal.domini.puertos.entrada;

import java.util.Optional;

import com.api.hexagonal.domini.modelo.Ong;

public interface ActualizarOngUseCase {
    Optional<Ong> updateOng(Integer id, Ong ong);
}
