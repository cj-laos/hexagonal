package com.api.hexagonal.aplicacion.service;

import org.springframework.stereotype.Service;

import com.api.hexagonal.aplicacion.mapper.RegionMapper;
import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.domini.puertos.entrada.RegistrarRegionUseCase;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateRegionService implements RegistrarRegionUseCase {
    private final RegionRepositoryPort regionRepositoryPort;

    @Override
    public Region createRegion(Region region) {
        RegionEntity entity = RegionMapper.toEntity(region);
        RegionEntity savedEntity = regionRepositoryPort.save(entity);
        return RegionMapper.toDomain(savedEntity);
    }

}
