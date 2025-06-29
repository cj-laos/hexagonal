package com.api.hexagonal.infraestructura.repository;

import java.util.List;
import java.util.Optional;

import com.api.hexagonal.domini.puertos.salida.SectorRepositoryPort;
import com.api.hexagonal.infraestructura.entity.SectorEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SectorRepositoryAdapter implements SectorRepositoryPort {

    private final JpaSectorRepository jpaSectorRepository;

    @Override
    public SectorEntity save(SectorEntity entity) {
        return jpaSectorRepository.save(entity);
    }

    @Override
    public Optional<SectorEntity> findById(Integer id) {
        return jpaSectorRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        jpaSectorRepository.deleteById(id);
    }

    @Override
    public List<SectorEntity> findAll() {
        return jpaSectorRepository.findAll();
    }

}
