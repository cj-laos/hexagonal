package com.api.hexagonal.infraestructura.controller.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteRequestDto {
    private String dni;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private Boolean verificadoReniec;
}
