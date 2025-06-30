package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

public class RegionMapper {
    public static Region toDomain(RegionEntity entity) {
        if (entity == null)
            return null;
        return new Region(entity.getId(), entity.getNombre());
    }

    public static RegionEntity toEntity(Region domain) {
        if (domain == null)
            return null;
        RegionEntity entity = new RegionEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        return entity;
    }
}
