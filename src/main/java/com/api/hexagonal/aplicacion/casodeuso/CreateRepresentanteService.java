package com.api.hexagonal.aplicacion.casodeuso;

import org.springframework.stereotype.Service;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.entrada.CreateRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateRepresentanteService implements CreateRepresentanteUseCase {

    private final RepresentanteRepositoryPort representanteRepositoryPort;

    @Override
    public Representante createRepresentante(Representante representante) {
        if (representanteRepositoryPort.existsByDni(representante.getDni())) {
            throw new IllegalArgumentException("Ya existe un representante con el DNI: " + representante.getDni());
        }
        representante.setVerificadoReniec(false);
        return representanteRepositoryPort.save(representante);
    }

}
