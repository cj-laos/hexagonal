package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;

public class RepresentanteMapper {
    public static Representante toDomain(RepresentanteEntity entity) {
        if (entity == null)
            return null;
        return new Representante(
                entity.getId(),
                entity.getDni(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getFechaNacimiento(),
                entity.getVerificadoReniec());
    }

    public static RepresentanteEntity toEntity(Representante domain) {
        if (domain == null)
            return null;
        RepresentanteEntity entity = new RepresentanteEntity();
        entity.setId(domain.getId());
        entity.setDni(domain.getDni());
        entity.setNombres(domain.getNombres());
        entity.setApellidos(domain.getApellidos());
        entity.setFechaNacimiento(domain.getFechaNacimiento());
        entity.setVerificadoReniec(domain.getVerificadoReniec());
        return entity;
    }
}
