package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.infraestructura.entity.AdjuntoEntity;
import com.api.hexagonal.infraestructura.entity.OngEntity;

public class AdjuntoMapper {
    public static Adjunto toDomain(AdjuntoEntity entity) {
        if (entity == null)
            return null;
        return new Adjunto(
                entity.getId(),
                entity.getOng() != null ? entity.getOng().getId() : null,
                entity.getUrlArchivo(),
                entity.getDescripcion());
    }

    public static AdjuntoEntity toEntity(Adjunto domain) {
        if (domain == null)
            return null;
        AdjuntoEntity entity = new AdjuntoEntity();
        entity.setId(domain.getId());
        entity.setUrlArchivo(domain.getUrlArchivo());
        entity.setDescripcion(domain.getDescripcion());
        if (domain.getOngId() != null) {
            OngEntity ongEntity = new OngEntity();
            ongEntity.setId(domain.getOngId());
            entity.setOng(ongEntity);
        }
        return entity;
    }
}