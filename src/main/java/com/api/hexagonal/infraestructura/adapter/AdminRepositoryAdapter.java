package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.AdminRepositoryPort;
import com.api.hexagonal.infraestructura.entity.UsuarioAdminEntity;
import com.api.hexagonal.infraestructura.repository.JpaAdminRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminRepositoryAdapter implements AdminRepositoryPort {

    private final JpaAdminRepository jpaUsuarioAdminRepository;

    @Override
    public UsuarioAdminEntity save(UsuarioAdminEntity admin) {
        return jpaUsuarioAdminRepository.save(admin);
    }

    @Override
    public Optional<UsuarioAdminEntity> findById(Integer id) {
        return jpaUsuarioAdminRepository.findById(id);
    }

    @Override
    public Optional<UsuarioAdminEntity> findByEmail(String email) {
        return jpaUsuarioAdminRepository.findByEmail(email);
    }

    @Override
    public void deleteById(Integer id) {
        jpaUsuarioAdminRepository.deleteById(id);
    }

    @Override
    public List<UsuarioAdminEntity> findAll() {
        return jpaUsuarioAdminRepository.findAll();
    }

}
