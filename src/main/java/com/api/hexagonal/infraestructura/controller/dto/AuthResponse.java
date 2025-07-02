// src/main/java/com/api/hexagonal/infraestructura/controller/dto/AuthResponse.java
package com.api.hexagonal.infraestructura.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private boolean success;
    private Integer adminId; // será null si falla el login
}
