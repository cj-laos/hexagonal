package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.infraestructura.controller.dto.OngRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.OngResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class OngControllerMapper {
    public static Ong toDomain(OngRequestDto dto) {
        if (dto == null)
            return null;
        return new Ong(
                null,
                dto.getNombre(),
                dto.getRuc(),
                dto.getRepresentanteId(),
                dto.getSectorId(),
                dto.getRegionId(),
                dto.getFechaRegistro());
    }

    public static OngResponseDto toDto(Ong domain) {
        if (domain == null)
            return null;
        return new OngResponseDto(
                domain.getId(),
                domain.getNombre(),
                domain.getRuc(),
                domain.getRepresentanteId(),
                domain.getSectorId(),
                domain.getRegionId(),
                domain.getFechaRegistro());
    }

    public static List<OngResponseDto> toDtoList(List<Ong> domainList) {
        return domainList.stream()
                .map(OngControllerMapper::toDto)
                .collect(Collectors.toList());
    }
}
