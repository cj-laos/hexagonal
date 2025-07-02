package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.infraestructura.controller.dto.ValidacionRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.ValidacionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ValidacionMapper {
    public static Validacion toDomain(ValidacionRequestDto dto) {
        if (dto == null)
            return null;
        return new Validacion(
                null,
                null,
                null,
                dto.getEstadoValidacion(),
                dto.getComentario(),
                dto.getFechaValidacion());
    }

    public static ValidacionResponseDto toDto(Validacion domain) {
        if (domain == null)
            return null;
        return new ValidacionResponseDto(
                domain.getId(),
                domain.getOngId(),
                domain.getAdminId(),
                domain.getEstadoValidacion(),
                domain.getComentario(),
                domain.getFechaValidacion());
    }

    public static List<ValidacionResponseDto> toDtoList(List<Validacion> domainList) {
        return domainList.stream()
                .map(ValidacionMapper::toDto)
                .collect(Collectors.toList());
    }
}