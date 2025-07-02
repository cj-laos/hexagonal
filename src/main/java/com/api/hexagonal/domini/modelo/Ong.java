package com.api.hexagonal.domini.modelo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ong {
    private Integer id;
    private String nombre;
    private String ruc;
    private String representanteId;
    private Integer sectorId;
    private Integer regionId;
    private LocalDateTime fechaRegistro;
}