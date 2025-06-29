package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

public class RegionMapper {
    public static RegionEntity toEntity(Region region) {
        if (region == null)
            return null;
        RegionEntity entity = new RegionEntity();
        entity.setId(region.getId());
        entity.setNombre(region.getNombre());
        return entity;
    }

    public static Region toDomain(RegionEntity entity) {
        if (entity == null)
            return null;
        Region region = new Region();
        region.setId(entity.getId());
        region.setNombre(entity.getNombre());
        return region;
    }
}
