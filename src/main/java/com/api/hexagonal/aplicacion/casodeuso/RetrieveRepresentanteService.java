package com.api.hexagonal.aplicacion.casodeuso;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.entrada.RetrieveRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetrieveRepresentanteService implements RetrieveRepresentanteUseCase {

    private final RepresentanteRepositoryPort representanteRepositoryPort;

    @Override
    public Optional<Representante> getRepresentanteById(Integer id) {
        return representanteRepositoryPort.findById(id);
    }

    @Override
    public List<Representante> getAllRepresentantes() {
        return representanteRepositoryPort.findAll();
    }

}
