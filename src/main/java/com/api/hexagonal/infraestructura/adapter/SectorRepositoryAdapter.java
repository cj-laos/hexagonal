package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import com.api.hexagonal.aplicacion.mapper.SectorMapper;
import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import com.api.hexagonal.infraestructura.entity.SectorEntity;
import com.api.hexagonal.infraestructura.repository.JpaSectorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SectorRepositoryAdapter implements SectorRepositoryPort {

    private final JpaSectorRepository jpaSectorRepository;

    @Override
    public Sector save(Sector sector) {
        SectorEntity entity = SectorMapper.toEntity(sector);
        SectorEntity savedEntity = jpaSectorRepository.save(entity);
        return SectorMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Sector> findById(Integer id) {
        return jpaSectorRepository.findById(id).map(SectorMapper::toDomain);
    }

    @Override
    public List<Sector> findAll() {
        return jpaSectorRepository.findAll().stream()
                .map(SectorMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaSectorRepository.existsById(id)) {
            jpaSectorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return jpaSectorRepository.existsByNombre(name);
    }
}