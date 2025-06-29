package com.api.hexagonal.domini.puertos.entrada;

import java.util.List;
import java.util.Optional;

import com.api.hexagonal.domini.modelo.Ong;

public interface BuscarOngUseCase {
    Optional<Ong> getOngById(Integer id);

    Optional<Ong> getOngByRuc(String ruc);

    List<Ong> getAllOngs();
}
