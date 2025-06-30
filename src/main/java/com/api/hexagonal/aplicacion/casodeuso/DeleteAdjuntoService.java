package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteAdjuntoUseCase;
import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAdjuntoService implements DeleteAdjuntoUseCase {

    private final AdjuntoRepositoryPort adjuntoRepositoryPort;

    @Override
    public boolean deleteAdjunto(Integer id) {
        return adjuntoRepositoryPort.deleteById(id);
    }
}