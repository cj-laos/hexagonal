package com.api.hexagonal.infraestructura.adapter;

import com.api.hexagonal.aplicacion.mapper.AdjuntoMapper;
import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.domini.puertos.salida.AdjuntoRepositoryPort;
import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;
import com.api.hexagonal.infraestructura.repository.AdjuntoRepository;
import com.api.hexagonal.infraestructura.repository.OngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdjuntoRepositoryAdapter implements AdjuntoRepositoryPort {

    private final AdjuntoRepository jpaAdjuntoRepository;
    private final OngRepository jpaOngRepository;

    @Override
    public Adjunto save(Adjunto adjunto) {
        AdjuntoEntity entity = AdjuntoMapper.toEntity(adjunto);
        if (adjunto.getOngId() != null) {
            jpaOngRepository.findById(adjunto.getOngId()).ifPresent(entity::setOng);
        }
        AdjuntoEntity savedEntity = jpaAdjuntoRepository.save(entity);
        return AdjuntoMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Adjunto> findById(Integer id) {
        return jpaAdjuntoRepository.findById(id).map(AdjuntoMapper::toDomain);
    }

    @Override
    public List<Adjunto> findAll() {
        return jpaAdjuntoRepository.findAll().stream()
                .map(AdjuntoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Adjunto> findByOngId(Integer ongId) {
        return jpaAdjuntoRepository.findByOngId(ongId).stream()
                .map(AdjuntoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaAdjuntoRepository.existsById(id)) {
            jpaAdjuntoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}