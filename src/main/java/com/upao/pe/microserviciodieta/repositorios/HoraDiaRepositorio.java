package com.upao.pe.microserviciodieta.repositorios;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoraDiaRepositorio extends JpaRepository<HoraDia, Long> {
    Optional<HoraDia> findByHora(String momentoDia);
}
