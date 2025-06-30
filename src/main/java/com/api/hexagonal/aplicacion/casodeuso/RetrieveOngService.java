package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.entrada.RetrieveOngUseCase;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveOngService implements RetrieveOngUseCase {

    private final OngRepositoryPort ongRepositoryPort;

    @Override
    public Optional<Ong> getOngById(Integer id) {
        return ongRepositoryPort.findById(id);
    }

    @Override
    public List<Ong> getAllOngs() {
        return ongRepositoryPort.findAll();
    }

    @Override
    public Optional<Ong> getOngByRuc(String ruc) {
        return ongRepositoryPort.findByRuc(ruc);
    }
}