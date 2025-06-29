package com.api.hexagonal.domini.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adjunto {
    private Integer id;
    private Ong ong;
    private String urlArchivo;
    private String descripcion;
}
