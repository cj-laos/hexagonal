package com.api.hexagonal.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.api.hexagonal.domini.puertos.salida.ValidacionRepositoryPort;
import com.api.hexagonal.infraestructura.entity.ValidacionEntity;
import com.api.hexagonal.infraestructura.repository.JpaValidacionRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ValidacionRepositoryAdapter implements ValidacionRepositoryPort {

    private final JpaValidacionRepository jpaValidacionRepository;

    @Override
    public ValidacionEntity save(ValidacionEntity validacion) {
        return jpaValidacionRepository.save(validacion);
    }

    @Override
    public Optional<ValidacionEntity> findById(Integer id) {
        return jpaValidacionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        jpaValidacionRepository.deleteById(id);
    }

    @Override
    public List<ValidacionEntity> findAll() {
        return jpaValidacionRepository.findAll();
    }

    @Override
    public List<ValidacionEntity> findByOngId(Integer ongId) {
        // En JpaValidacionRepository, necesitarías un método como
        // List<ValidacionEntity> findByOng_Id(Integer ongId);
        // Si no existe, puedes crearlo o adaptar esta lógica.
        return jpaValidacionRepository.findAll().stream()
                .filter(v -> v.getOng() != null && v.getOng().getId().equals(ongId))
                .toList();
    }

}
