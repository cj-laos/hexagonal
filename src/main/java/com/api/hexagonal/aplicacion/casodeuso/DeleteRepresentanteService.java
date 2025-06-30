package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteRepresentanteUseCase;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRepresentanteService implements DeleteRepresentanteUseCase {
    private final RepresentanteRepositoryPort representanteRepositoryPort;

    @Override
    public boolean deleteRepresentante(Integer id) {
        return representanteRepositoryPort.deleteById(id);
    }
}
