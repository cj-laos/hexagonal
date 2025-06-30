package com.api.hexagonal.infraestructura.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegionResponseDto {
    private Integer id;
    private String nombre;
}