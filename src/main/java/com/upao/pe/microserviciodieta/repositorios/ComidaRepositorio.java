package com.upao.pe.microserviciodieta.repositorios;


import com.upao.pe.microserviciodieta.modelos.Comida;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComidaRepositorio extends MongoRepository<Comida, String> {
    Optional<Comida> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
