package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdminRequestDto {
    private String nombre;
    private String email;
    private String pass;
}