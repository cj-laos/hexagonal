package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.Region;
import com.api.hexagonal.infraestructura.controller.dto.RegionRequest;
import com.api.hexagonal.infraestructura.controller.dto.RegionResponse;

public class RegionDtoMapper {
    public static Region toDomain(RegionRequest request) {
        if (request == null)
            return null;
        Region region = new Region();
        region.setNombre(request.getNombre());
        return region;
    }

    public static RegionResponse toResponse(Region region) {
        if (region == null)
            return null;
        RegionResponse response = new RegionResponse();
        response.setId(region.getId());
        response.setNombre(region.getNombre());
        return response;
    }
}
