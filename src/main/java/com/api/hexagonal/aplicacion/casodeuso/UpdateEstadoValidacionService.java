package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.entrada.UpdateEstadoValidacionUseCase;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateEstadoValidacionService implements UpdateEstadoValidacionUseCase {

    private final ValidacionRepositoryPort repository;

    @Override
    public boolean actualizarEstado(Integer id, String nuevoEstado) {
        Optional<Validacion> optional = repository.findById(id);
        if (optional.isPresent()) {
            Validacion validacion = optional.get();
            validacion.setEstadoValidacion(nuevoEstado);
            repository.save(validacion);
            return true;
        }
        return false;
    }
}
