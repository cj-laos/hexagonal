package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionResponseDto {
    private Integer id;
    private Integer ongId;
    private Integer adminId;
    private String estadoValidacion;
    private String comentario;
    private LocalDateTime fechaValidacion;
}