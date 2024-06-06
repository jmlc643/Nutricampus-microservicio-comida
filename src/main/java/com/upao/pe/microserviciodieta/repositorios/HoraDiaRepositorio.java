package com.upao.pe.microserviciodieta.repositorios;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraDiaRepositorio extends JpaRepository<HoraDia, Long> {
}
