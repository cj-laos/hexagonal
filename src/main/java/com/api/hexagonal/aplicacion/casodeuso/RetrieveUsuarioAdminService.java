package com.api.hexagonal.aplicacion.casodeuso;

import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.domini.puertos.entrada.RetrieveUsuarioAdminUseCase;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RetrieveUsuarioAdminService implements RetrieveUsuarioAdminUseCase {

    private final UsuarioAdminRepositoryPort usuarioAdminRepositoryPort;

    @Override
    public Optional<UsuarioAdmin> getUsuarioAdminById(Integer id) {
        return usuarioAdminRepositoryPort.findById(id);
    }

    @Override
    public List<UsuarioAdmin> getAllUsuariosAdmin() {
        return usuarioAdminRepositoryPort.findAll();
    }

    @Override
    public Optional<UsuarioAdmin> getUsuarioAdminByEmail(String email) {
        return usuarioAdminRepositoryPort.findByEmail(email);
    }
}
