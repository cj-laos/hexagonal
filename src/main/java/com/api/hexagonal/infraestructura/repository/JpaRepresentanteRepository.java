package com.api.hexagonal.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.hexagonal.infraestructura.entity.RepresentanteEntity;

public interface JpaRepresentanteRepository extends JpaRepository<RepresentanteEntity, Integer> {

}
