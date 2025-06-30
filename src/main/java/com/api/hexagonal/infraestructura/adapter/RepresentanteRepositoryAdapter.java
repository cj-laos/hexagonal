package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.aplicacion.mapper.RepresentanteMapper;
import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.domini.puertos.salida.RepresentanteRepositoryPort;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;
import com.api.hexagonal.infraestructura.repository.RepresentanteRepository;

import lombok.RequiredArgsConstructor;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RepresentanteRepositoryAdapter implements RepresentanteRepositoryPort {

    private final RepresentanteRepository jpaRepresentanteRepository;

    @Override
    public Representante save(Representante representante) {
        RepresentanteEntity entity = RepresentanteMapper.toEntity(representante);
        RepresentanteEntity savedEntity = jpaRepresentanteRepository.save(entity);
        return RepresentanteMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Representante> findById(Integer id) {
        return jpaRepresentanteRepository.findById(id).map(RepresentanteMapper::toDomain);
    }

    @Override
    public Optional<Representante> findByDni(String dni) {
        return jpaRepresentanteRepository.findByDni(dni).map(RepresentanteMapper::toDomain);
    }

    @Override
    public List<Representante> findAll() {
        return jpaRepresentanteRepository.findAll().stream()
                .map(RepresentanteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaRepresentanteRepository.existsById(id)) {
            jpaRepresentanteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByDni(String dni) {
        return jpaRepresentanteRepository.existsByDni(dni);
    }
}