package com.api.hexagonal.domini.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sector {
    private Integer id;
    private String nombre;
}