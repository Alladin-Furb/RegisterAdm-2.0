package com.transporte.escolar.repository;

import com.transporte.escolar.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MotoristaRepository extends JpaRepository<Motorista, UUID> {
}
