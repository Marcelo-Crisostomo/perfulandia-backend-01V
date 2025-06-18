package com.perfulandia.boletaservice.repository;


import com.perfulandia.boletaservice.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletaRepository extends JpaRepository<Boleta, Long> {
}