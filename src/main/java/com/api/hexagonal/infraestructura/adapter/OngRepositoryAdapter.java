package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.infraestructura.entity.OngEntity;
import com.api.hexagonal.infraestructura.repository.JpaOngRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OngRepositoryAdapter implements OngRepositoryPort {

    private final JpaOngRepository jpaOngRepository;

    @Override
    public OngEntity save(OngEntity ong) {
        return jpaOngRepository.save(ong);
    }

    @Override
    public Optional<OngEntity> findById(Integer id) {
        return jpaOngRepository.findById(id);
    }

    @Override
    public Optional<OngEntity> findByRuc(String ruc) {
        return jpaOngRepository.findByRuc(ruc);
    }

    @Override
    public void deleteById(Integer id) {
        jpaOngRepository.deleteById(id);
    }

    @Override
    public List<OngEntity> findAll() {
        return jpaOngRepository.findAll();
    }

}
