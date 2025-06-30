package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;
import com.api.hexagonal.infraestructura.repository.JpaAdjuntoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdjuntoRepositoryAdapter implements AdjuntoRepositoryPort {

    private final JpaAdjuntoRepository jpaAdjuntoRepository;

    @Override
    public AdjuntoEntity save(AdjuntoEntity adjunto) {
        return jpaAdjuntoRepository.save(adjunto);
    }

    @Override
    public Optional<AdjuntoEntity> findById(Integer id) {
        return jpaAdjuntoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        jpaAdjuntoRepository.deleteById(id);
    }

    @Override
    public List<AdjuntoEntity> findAll() {
        return jpaAdjuntoRepository.findAll();
    }

    @Override
    public List<AdjuntoEntity> findByOngId(Integer ongId) {
        // Asumiendo que puedes tener un método en JpaAdjuntoRepository como
        // findByOng_Id
        return jpaAdjuntoRepository.findAll().stream()
                .filter(a -> a.getOng() != null && a.getOng().getId().equals(ongId))
                .toList();
    }

}
