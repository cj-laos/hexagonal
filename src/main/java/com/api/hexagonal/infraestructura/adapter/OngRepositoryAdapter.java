package com.api.hexagonal.infraestructura.adapter;

import com.api.hexagonal.aplicacion.mapper.OngMapper;
import com.api.hexagonal.domini.modelo.Ong;
import com.api.hexagonal.domini.puertos.salida.OngRepositoryPort;
import com.api.hexagonal.infraestructura.entity.OngEntity;
import com.api.hexagonal.infraestructura.repository.OngRepository;
import com.api.hexagonal.infraestructura.repository.RepresentanteRepository;
import com.api.hexagonal.infraestructura.repository.SectorRepository;
import com.api.hexagonal.infraestructura.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OngRepositoryAdapter implements OngRepositoryPort {

    private final OngRepository jpaOngRepository;
    private final RepresentanteRepository jpaRepresentanteRepository;
    private final SectorRepository jpaSectorRepository;
    private final RegionRepository jpaRegionRepository;

    @Override
    public Ong save(Ong ong) {
        OngEntity entity = OngMapper.toEntity(ong);
        if (ong.getRepresentanteId() != null) {
            jpaRepresentanteRepository.findById(ong.getRepresentanteId()).ifPresent(entity::setRepresentante);
        }
        if (ong.getSectorId() != null) {
            jpaSectorRepository.findById(ong.getSectorId()).ifPresent(entity::setSector);
        }
        if (ong.getRegionId() != null) {
            jpaRegionRepository.findById(ong.getRegionId()).ifPresent(entity::setRegion);
        }
        OngEntity savedEntity = jpaOngRepository.save(entity);
        return OngMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Ong> findById(Integer id) {
        return jpaOngRepository.findById(id).map(OngMapper::toDomain);
    }

    @Override
    public Optional<Ong> findByRuc(String ruc) {
        return jpaOngRepository.findByRuc(ruc).map(OngMapper::toDomain);
    }

    @Override
    public List<Ong> findAll() {
        return jpaOngRepository.findAll().stream()
                .map(OngMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (jpaOngRepository.existsById(id)) {
            jpaOngRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByRuc(String ruc) {
        return jpaOngRepository.existsByRuc(ruc);
    }
}