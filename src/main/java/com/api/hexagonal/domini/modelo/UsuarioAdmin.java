package com.api.hexagonal.domini.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioAdmin {
    private Integer id;
    private String nombre;
    private String email;
    private String pass;
}
