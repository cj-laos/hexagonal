package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.domini.puertos.entrada.UpdateUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateUsuarioAdminService implements UpdateUsuarioAdminUseCase {

    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<UsuarioAdmin> updateUsuarioAdmin(Integer id, UsuarioAdmin updatedUsuarioAdmin) {
        return usuarioAdminRepositoryPort.findById(id).map(existingUsuarioAdmin -> {
            existingUsuarioAdmin.setNombre(updatedUsuarioAdmin.getNombre());
            if (updatedUsuarioAdmin.getPass() != null && !updatedUsuarioAdmin.getPass().isEmpty()) {
                existingUsuarioAdmin.setPass(passwordEncoder.encode(updatedUsuarioAdmin.getPass()));
            }
            if (!existingUsuarioAdmin.getEmail().equals(updatedUsuarioAdmin.getEmail())) {
                if (usuarioAdminRepositoryPort.existsByEmail(updatedUsuarioAdmin.getEmail())) {
                    throw new IllegalArgumentException("El nuevo email ya está registrado para otro usuario admin.");
                }
                existingUsuarioAdmin.setEmail(updatedUsuarioAdmin.getEmail());
            }

            return usuarioAdminRepositoryPort.save(existingUsuarioAdmin);
        });
    }
}