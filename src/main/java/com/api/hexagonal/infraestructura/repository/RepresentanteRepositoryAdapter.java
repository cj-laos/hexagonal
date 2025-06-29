package com.api.hexagonal.infraestructura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RepresentanteRepositoryAdapter implements RepresentanteRepositoryPort {

    private final JpaRepresentanteRepository jpaRepresentanteRepository;

    @Override
    public RepresentanteEntity save(RepresentanteEntity entity) {
        return jpaRepresentanteRepository.save(entity);
    }

    @Override
    public Optional<RepresentanteEntity> findById(Integer id) {
        return jpaRepresentanteRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepresentanteRepository.deleteById(id);

    }

    @Override
    public List<RepresentanteEntity> findAll() {
        return jpaRepresentanteRepository.findAll();
    }

}
