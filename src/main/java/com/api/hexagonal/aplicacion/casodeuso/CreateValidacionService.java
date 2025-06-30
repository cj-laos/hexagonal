package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.entrada.CreateValidacionUseCase;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateValidacionService implements CreateValidacionUseCase {

    private final ValidacionRepositoryPort validacionRepositoryPort;
    private final OngRepositoryPort ongRepositoryPort;
    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;

    @Override
    public Validacion createValidacion(Validacion validacion) {
        if (validacion.getOngId() != null && !ongRepositoryPort.findById(validacion.getOngId()).isPresent()) {
            throw new IllegalArgumentException("La ONG con ID " + validacion.getOngId() + " no existe.");
        }
        if (validacion.getAdminId() != null
                && !usuarioAdminRepositoryPort.findById(validacion.getAdminId()).isPresent()) {
            throw new IllegalArgumentException("El Usuario Admin con ID " + validacion.getAdminId() + " no existe.");
        }

        if (validacion.getFechaValidacion() == null) {
            validacion.setFechaValidacion(LocalDateTime.now());
        }

        return validacionRepositoryPort.save(validacion);
    }
}