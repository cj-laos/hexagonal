package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.infraestructura.controller.dto.RegionRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.RegionResponseDto;

public class RegionDtoMapper {
    public static Region toDomain(RegionRequestDto request) {
        if (request == null)
            return null;
        Region region = new Region();
        region.setNombre(request.getNombre());
        return region;
    }

    public static RegionResponseDto toResponse(Region region) {
        if (region == null)
            return null;
        RegionResponseDto response = new RegionResponseDto();
        response.setId(region.getId());
        response.setNombre(region.getNombre());
        return response;
    }
}
