package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.infraestructura.entity.OngEntity;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;
import com.api.hexagonal.infraestructura.entity.SectorEntity;
import com.api.hexagonal.infraestructura.entity.RegionEntity;

public class OngMapper {
    public static Ong toDomain(OngEntity entity) {
        if (entity == null)
            return null;
        return new Ong(
                entity.getId(),
                entity.getNombre(),
                entity.getRuc(),
                entity.getRepresentante() != null ? String.valueOf(entity.getRepresentante().getId()) : null,
                entity.getSector() != null ? entity.getSector().getId() : null,
                entity.getRegion() != null ? entity.getRegion().getId() : null,
                entity.getFechaRegistro());

    }

    public static OngEntity toEntity(Ong domain) {
        if (domain == null)
            return null;
        OngEntity entity = new OngEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setRuc(domain.getRuc());
        entity.setFechaRegistro(domain.getFechaRegistro());

        if (domain.getRepresentanteId() != null) {
            RepresentanteEntity representanteEntity = new RepresentanteEntity();
            representanteEntity.setId(Integer.valueOf(domain.getRepresentanteId()));
            entity.setRepresentante(representanteEntity);
        }
        if (domain.getSectorId() != null) {
            SectorEntity sectorEntity = new SectorEntity();
            sectorEntity.setId(domain.getSectorId());
            entity.setSector(sectorEntity);
        }
        if (domain.getRegionId() != null) {
            RegionEntity regionEntity = new RegionEntity();
            regionEntity.setId(domain.getRegionId());
            entity.setRegion(regionEntity);
        }
        return entity;
    }
}