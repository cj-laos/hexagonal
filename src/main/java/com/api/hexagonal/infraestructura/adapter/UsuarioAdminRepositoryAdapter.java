package com.api.hexagonal.infraestructura.adapter;

import com.api.hexagonal.aplicacion.mapper.UsuarioAdminMapper;
import com.api.hexagonal.domini.modelo.UsuarioAdmin;
import com.api.hexagonal.domini.puertos.salida.UsuarioAdminRepositoryPort;
import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;
import com.api.hexagonal.infraestructura.repository.UsuarioAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioAdminRepositoryAdapter implements UsuarioAdminRepositoryPort {

    private final UsuarioAdminRepository jpaUsuarioAdminRepository;

    @Override
    public UsuarioAdmin save(UsuarioAdmin usuarioAdmin) {
        UsuarioAdminEntity entity = UsuarioAdminMapper.toEntity(usuarioAdmin);
        UsuarioAdminEntity savedEntity = jpaUsuarioAdminRepository.save(entity);
        return UsuarioAdminMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<UsuarioAdmin> findById(Integer id) {
        return jpaUsuarioAdminRepository.findById(id).map(UsuarioAdminMapper::toDomain);
    }

    @Override
    public Optional<UsuarioAdmin> findByEmail(String email) {
        return jpaUsuarioAdminRepository.findByEmail(email).map(UsuarioAdminMapper::toDomain);
    }

    @Override
    public List<UsuarioAdmin> findAll() {
        return jpaUsuarioAdminRepository.findAll().stream()
                .map(UsuarioAdminMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaUsuarioAdminRepository.existsById(id)) {
            jpaUsuarioAdminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUsuarioAdminRepository.existsByEmail(email);
    }
}