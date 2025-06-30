package com.api.hexagonal.infraestructura.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.api.hexagonal.domini.modelo.Representante;
import com.api.hexagonal.infraestructura.controller.dto.RepresentanteRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.RepresentanteResponseDto;

public class RepresentanteControllerMapper {
    public static Representante toDomain(RepresentanteRequestDto dto) {
        if (dto == null)
            return null;
        return new Representante(
                null,
                dto.getDni(),
                dto.getNombres(),
                dto.getApellidos(),
                dto.getFechaNacimiento(),
                dto.getVerificadoReniec() != null ? dto.getVerificadoReniec() : false);
    }

    public static RepresentanteResponseDto toDto(Representante domain) {
        if (domain == null)
            return null;
        return new RepresentanteResponseDto(
                domain.getId(),
                domain.getDni(),
                domain.getNombres(),
                domain.getApellidos(),
                domain.getFechaNacimiento(),
                domain.getVerificadoReniec());
    }

    public static List<RepresentanteResponseDto> toDtoList(List<Representante> domainList) {
        return domainList.stream()
                .map(RepresentanteControllerMapper::toDto)
                .collect(Collectors.toList());
    }
}