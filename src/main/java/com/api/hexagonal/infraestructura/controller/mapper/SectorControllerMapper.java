package com.api.hexagonal.infraestructura.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.api.hexagonal.domini.modelo.Sector;
import com.api.hexagonal.infraestructura.controller.dto.SectorRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.SectorResponseDto;

public class SectorControllerMapper {
    public static Sector toDomain(SectorRequestDto dto) {
        if (dto == null)
            return null;
        return new Sector(null, dto.getNombre());
    }

    public static SectorResponseDto toDto(Sector domain) {
        if (domain == null)
            return null;
        return new SectorResponseDto(domain.getId(), domain.getNombre());
    }

    public static List<SectorResponseDto> toDtoList(List<Sector> domainList) {
        return domainList.stream()
                .map(SectorControllerMapper::toDto)
                .collect(Collectors.toList());
    }
}
