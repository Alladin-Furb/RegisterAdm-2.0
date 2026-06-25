package com.transporte.escolar.repository;

import com.transporte.escolar.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {
}
