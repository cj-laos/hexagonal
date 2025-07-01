package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.domini.puertos.entrada.CreateUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUsuarioAdminService implements CreateUsuarioAdminUseCase {

    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioAdmin createUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
        if (usuarioAdminRepositoryPort.existsByEmail(usuarioAdmin.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario admin con el email: " + usuarioAdmin.getEmail());
        }
        usuarioAdmin.setPass(passwordEncoder.encode(usuarioAdmin.getPass()));
        return usuarioAdminRepositoryPort.save(usuarioAdmin);
    }
}
