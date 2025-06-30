package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteOngUseCase;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOngService implements DeleteOngUseCase {

    private final OngRepositoryPort ongRepositoryPort;

    @Override
    public boolean deleteOng(Integer id) {
        return ongRepositoryPort.deleteById(id);
    }

}
