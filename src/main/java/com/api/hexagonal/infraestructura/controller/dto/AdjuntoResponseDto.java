package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdjuntoResponseDto {
    private Integer id;
    private Integer ongId;
    private String urlArchivo;
    private String descripcion;
}
