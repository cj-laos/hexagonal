package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteResponseDto {
    private Integer id;
    private String dni;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private Boolean verificadoReniec;
}