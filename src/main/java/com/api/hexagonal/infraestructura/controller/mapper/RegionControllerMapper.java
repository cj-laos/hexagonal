package com.api.hexagonal.infraestructura.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.infraestructura.controller.dto.RegionRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.RegionResponseDto;

public class RegionControllerMapper {
    public static Region toDomain(RegionRequestDto dto) {
        if (dto == null)
            return null;
        return new Region(null, dto.getNombre());
    }

    public static RegionResponseDto toDto(Region domain) {
        if (domain == null)
            return null;
        return new RegionResponseDto(domain.getId(), domain.getNombre());
    }

    public static List<RegionResponseDto> toDtoList(List<Region> domainList) {
        return domainList.stream()
                .map(RegionControllerMapper::toDto)
                .collect(Collectors.toList());
    }
}
