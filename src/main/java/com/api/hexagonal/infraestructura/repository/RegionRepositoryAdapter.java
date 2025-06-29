package com.api.hexagonal.infraestructura.repository;

import java.util.List;
import java.util.Optional;
import com.api.hexagonal.domini.puertos.salida.RegionRepositoryPort;
import com.api.hexagonal.infraestructura.entity.RegionEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegionRepositoryAdapter implements RegionRepositoryPort {

    private final JpaRegionRepository jpaRegionRepository;

    @Override
    public RegionEntity save(RegionEntity entity) {
        return jpaRegionRepository.save(entity);
    }

    @Override
    public Optional<RegionEntity> findById(Integer id) {
        return jpaRegionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        jpaRegionRepository.deleteById(id);
    }

    @Override
    public List<RegionEntity> findAll() {
        return jpaRegionRepository.findAll();
    }

}
