package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.infraestructura.entity.SectorEntity;

public class SectorMapper {
    public static Sector toDomain(SectorEntity entity) {
        if (entity == null)
            return null;
        return new Sector(entity.getId(), entity.getNombre());
    }

    public static SectorEntity toEntity(Sector domain) {
        if (domain == null)
            return null;
        SectorEntity entity = new SectorEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        return entity;
    }
}
