package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.infraestructura.controller.dto.UsuarioAdminRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.UsuarioAdminResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioAdminMapper {
    public static UsuarioAdmin toDomain(UsuarioAdminRequestDto dto) {
        if (dto == null)
            return null;
        return new UsuarioAdmin(
                null,
                dto.getNombre(),
                dto.getEmail(),
                dto.getPass());
    }

    public static UsuarioAdminResponseDto toDto(UsuarioAdmin domain) {
        if (domain == null)
            return null;
        return new UsuarioAdminResponseDto(
                domain.getId(),
                domain.getNombre(),
                domain.getEmail(),
                domain.getPass());
    }

    public static List<UsuarioAdminResponseDto> toDtoList(List<UsuarioAdmin> domainList) {
        return domainList.stream()
                .map(UsuarioAdminMapper::toDto)
                .collect(Collectors.toList());
    }
}
