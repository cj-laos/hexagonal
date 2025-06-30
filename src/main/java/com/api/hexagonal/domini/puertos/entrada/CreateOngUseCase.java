package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Ong;

public interface CreateOngUseCase {
    Ong createOng(Ong ong);
}
