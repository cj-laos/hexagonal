package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import com.api.hexagonal.aplicacion.mapper.RegionMapper;
import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import com.api.hexagonal.infraestructura.entity.RegionEntity;
import com.api.hexagonal.infraestructura.repository.JpaRegionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RegionRepositoryAdapter implements RegionRepositoryPort {

    private final JpaRegionRepository jpaRegionRepository;

    @Override
    public Region save(Region region) {
        RegionEntity entity = RegionMapper.toEntity(region);
        RegionEntity savedEntity = jpaRegionRepository.save(entity);
        return RegionMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return jpaRegionRepository.findById(id).map(RegionMapper::toDomain);
    }

    @Override
    public List<Region> findAll() {
        return jpaRegionRepository.findAll().stream()
                .map(RegionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaRegionRepository.existsById(id)) {
            jpaRegionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRegionRepository.existsByNombre(name);
    }
}
