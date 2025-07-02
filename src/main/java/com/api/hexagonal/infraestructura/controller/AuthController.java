package com.api.hexagonal.infraestructura.controller;

import com.api.hexagonal.infraestructura.controller.dto.AuthRequest;
import com.api.hexagonal.infraestructura.controller.dto.AuthResponse;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UsuarioAdminRepositoryPort adminRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            @Qualifier("usuarioAdminRepositoryAdapter") UsuarioAdminRepositoryPort adminRepo,
            PasswordEncoder passwordEncoder) {
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return adminRepo.findByEmail(request.getEmail())
                .map(admin -> {
                    boolean success = passwordEncoder.matches(request.getPassword(), admin.getPass());
                    return ResponseEntity.ok(new AuthResponse(success, success ? admin.getId() : null));
                })
                .orElse(ResponseEntity.ok(new AuthResponse(false, null)));
    }
}
