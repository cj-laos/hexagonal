package com.api.hexagonal.infraestructura.adapter;

import com.api.hexagonal.aplicacion.mapper.ValidacionMapper;
import com.api.hexagonal.domini.modelo.Validacion;
import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import com.api.hexagonal.infraestructura.entity.ValidacionEntity;
import com.api.hexagonal.infraestructura.repository.ValidacionRepository;
import com.api.hexagonal.infraestructura.repository.OngRepository;
import com.api.hexagonal.infraestructura.repository.UsuarioAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ValidacionRepositoryAdapter implements ValidacionRepositoryPort {

    private final ValidacionRepository jpaValidacionRepository;
    private final OngRepository jpaOngRepository;
    private final UsuarioAdminRepository jpaUsuarioAdminRepository;

    @Override
    public Validacion save(Validacion validacion) {
        ValidacionEntity entity = ValidacionMapper.toEntity(validacion);
        if (validacion.getOngId() != null) {
            jpaOngRepository.findById(validacion.getOngId()).ifPresent(entity::setOng);
        }
        if (validacion.getAdminId() != null) {
            jpaUsuarioAdminRepository.findById(validacion.getAdminId()).ifPresent(entity::setAdmin);
        }
        ValidacionEntity savedEntity = jpaValidacionRepository.save(entity);
        return ValidacionMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Validacion> findById(Integer id) {
        return jpaValidacionRepository.findById(id).map(ValidacionMapper::toDomain);
    }

    @Override
    public List<Validacion> findAll() {
        return jpaValidacionRepository.findAll().stream()
                .map(ValidacionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Validacion> findByOngId(Integer ongId) {
        return jpaValidacionRepository.findByOngId(ongId).stream()
                .map(ValidacionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaValidacionRepository.existsById(id)) {
            jpaValidacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}