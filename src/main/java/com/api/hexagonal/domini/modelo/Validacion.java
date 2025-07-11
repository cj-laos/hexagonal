package com.api.hexagonal.domini.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Validacion {
    private Integer id;
    private Integer ongId;
    private Integer adminId;
    private String estadoValidacion;
    private String comentario;
    private LocalDateTime fechaValidacion;
}
