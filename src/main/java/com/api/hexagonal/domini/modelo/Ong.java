package com.api.hexagonal.domini.modelo;

import java.time.LocalDateTime;
import java.util.List;

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
    private Representante representante;
    private Sector sector;
    private Region region;
    private LocalDateTime fechaRegistro;
    private List<Validacion> validaciones;
    private List<Adjunto> adjuntos;
}