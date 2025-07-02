package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdjuntoRequestDto {
    // AdjuntoRequestDto.java
    private String descripcion;
    private String urlArchivo;
    private String ruc;
}