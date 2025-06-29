package com.api.hexagonal.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hexagonal.infraestructura.entity.ValidacionEntity;

public interface JpaValidacionRepository extends JpaRepository<ValidacionEntity, Integer> {

}
