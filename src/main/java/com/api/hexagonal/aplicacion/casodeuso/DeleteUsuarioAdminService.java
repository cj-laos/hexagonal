package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.puertos.entrada.DeleteUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUsuarioAdminService implements DeleteUsuarioAdminUseCase {

    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;

    @Override
    public boolean deleteUsuarioAdmin(Integer id) {
        return usuarioAdminRepositoryPort.deleteById(id);
    }
}