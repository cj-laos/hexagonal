package com.api.hexagonal.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hexagonal.infraestructura.entity.ValidacionEntity;

public interface ValidacionRepository extends JpaRepository<ValidacionEntity, Integer> {
    List<ValidacionEntity> findByOngId(Integer ongId);
}
