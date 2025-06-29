package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Ong;

public interface RegistrarOngUseCase {
    Ong createOng(Ong ong);
}
