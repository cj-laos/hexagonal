package com.api.hexagonal.infraestructura.controller.mapper;

import com.api.hexagonal.domini.modelo.Adjunto;
import com.api.hexagonal.infraestructura.controller.dto.AdjuntoRequestDto;
import com.api.hexagonal.infraestructura.controller.dto.AdjuntoResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class AdjuntoMapper {
    public static Adjunto toDomain(AdjuntoRequestDto dto) {
        if (dto == null)
            return null;
        return new Adjunto(
                null,
                dto.getOngId(),
                dto.getUrlArchivo(),
                dto.getDescripcion());
    }

    public static AdjuntoResponseDto toDto(Adjunto domain) {
        if (domain == null)
            return null;
        return new AdjuntoResponseDto(
                domain.getId(),
                domain.getOngId(),
                domain.getUrlArchivo(),
                domain.getDescripcion());
    }

    public static List<AdjuntoResponseDto> toDtoList(List<Adjunto> domainList) {
        return domainList.stream()
                .map(AdjuntoMapper::toDto)
                .collect(Collectors.toList());
    }
}