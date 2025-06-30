package com.api.hexagonal.aplicacion.casodeuso;

import java.util.Optional;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRepresentanteByDniUseCase;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveRepresentanteByDniService implements RetrieveRepresentanteByDniUseCase {

    private final RepresentanteRepositoryPort representanteRepositoryPort;

    @Override
    public Optional<Representante> getRepresentanteByDni(String dni) {
        return representanteRepositoryPort.findByDni(dni);
    }

}
