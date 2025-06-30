package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteValidacionUseCase;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteValidacionService implements DeleteValidacionUseCase {

    private final ValidacionRepositoryPort validacionRepositoryPort;

    @Override
    public boolean deleteValidacion(Integer id) {
        return validacionRepositoryPort.deleteById(id);
    }
}