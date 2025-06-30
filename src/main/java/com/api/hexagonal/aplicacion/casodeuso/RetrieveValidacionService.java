package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.entrada.RetrieveValidacionUseCase;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveValidacionService implements RetrieveValidacionUseCase {

    private final ValidacionRepositoryPort validacionRepositoryPort;

    @Override
    public Optional<Validacion> getValidacionById(Integer id) {
        return validacionRepositoryPort.findById(id);
    }

    @Override
    public List<Validacion> getAllValidaciones() {
        return validacionRepositoryPort.findAll();
    }

    @Override
    public List<Validacion> getValidacionesByOngId(Integer ongId) {
        return validacionRepositoryPort.findByOngId(ongId);
    }
}
