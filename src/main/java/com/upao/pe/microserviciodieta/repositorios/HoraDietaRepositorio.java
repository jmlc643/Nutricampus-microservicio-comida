package com.upao.pe.microserviciodieta.repositorios;


import com.upao.pe.microserviciodieta.modelos.HoraDieta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraDietaRepositorio extends JpaRepository<HoraDieta, Long> {
}
