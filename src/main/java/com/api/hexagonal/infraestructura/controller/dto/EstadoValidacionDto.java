// EstadoValidacionDto.java
package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoValidacionDto {
    private String estadoValidacion;
    private Integer adminId; // nuevo campo
}
