package com.upao.pe.microserviciodieta.repositorios;

import com.upao.pe.microserviciodieta.modelos.DietaComida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietaComidaRepositorio extends JpaRepository<DietaComida, Long> {
}
