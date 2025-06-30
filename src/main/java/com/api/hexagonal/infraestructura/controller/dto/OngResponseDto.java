package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngResponseDto {
    private Integer id;
    private String nombre;
    private String ruc;
    private Integer representanteId;
    private Integer sectorId;
    private Integer regionId;
    private LocalDateTime fechaRegistro;
}
