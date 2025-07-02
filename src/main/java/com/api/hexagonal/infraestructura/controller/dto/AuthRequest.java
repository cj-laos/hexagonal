package com.api.hexagonal.infraestructura.controller.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
