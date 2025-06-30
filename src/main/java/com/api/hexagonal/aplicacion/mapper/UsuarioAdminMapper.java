package com.api.hexagonal.aplicacion.mapper;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;

public class UsuarioAdminMapper {
    public static UsuarioAdmin toDomain(UsuarioAdminEntity entity) {
        if (entity == null)
            return null;
        return new UsuarioAdmin(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail(),
                entity.getPassword());
    }

    public static UsuarioAdminEntity toEntity(UsuarioAdmin domain) {
        if (domain == null)
            return null;
        UsuarioAdminEntity entity = new UsuarioAdminEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPass());
        return entity;
    }
}