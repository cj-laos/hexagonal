package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.infraestructura.entity.ValidacionEntity;
import com.api.hexagonal.infraestructura.entity.OngEntity;
import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;

public class ValidacionMapper {
    public static Validacion toDomain(ValidacionEntity entity) {
        if (entity == null)
            return null;
        return new Validacion(
                entity.getId(),
                entity.getOng() != null ? entity.getOng().getId() : null,
                entity.getAdmin() != null ? entity.getAdmin().getId() : null,
                entity.getEstadoValidacion(),
                entity.getComentario(),
                entity.getFechaValidacion());
    }

    public static ValidacionEntity toEntity(Validacion domain) {
        if (domain == null)
            return null;
        ValidacionEntity entity = new ValidacionEntity();
        entity.setId(domain.getId());
        entity.setEstadoValidacion(domain.getEstadoValidacion());
        entity.setComentario(domain.getComentario());
        entity.setFechaValidacion(domain.getFechaValidacion());

        if (domain.getOngId() != null) {
            OngEntity ongEntity = new OngEntity();
            ongEntity.setId(domain.getOngId());
            entity.setOng(ongEntity);
        }
        if (domain.getAdminId() != null) {
            UsuarioAdminEntity adminEntity = new UsuarioAdminEntity();
            adminEntity.setId(domain.getAdminId());
            entity.setAdmin(adminEntity);
        }
        return entity;
    }
}