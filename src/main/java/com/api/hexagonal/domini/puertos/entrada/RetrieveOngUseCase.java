package com.api.hexagonal.domini.puertos.entrada;

import com.api.hexagonal.domini.modelo.Ong;
import java.util.List;
import java.util.Optional;

public interface RetrieveOngUseCase {
    Optional<Ong> getOngById(Integer id);

    List<Ong> getAllOngs();

    Optional<Ong> getOngByRuc(String ruc);
}