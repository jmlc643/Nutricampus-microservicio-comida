package com.upao.pe.microserviciodieta.repositorios;

import com.upao.pe.microserviciodieta.modelos.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaRepositorio extends JpaRepository<Dieta, Long> {
}
