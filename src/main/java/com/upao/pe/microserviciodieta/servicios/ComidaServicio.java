package com.upao.pe.microserviciodieta.servicios;

import com.upao.pe.microserviciodieta.modelos.Comida;
import com.upao.pe.microserviciodieta.repositorios.ComidaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComidaServicio {

    @Autowired private ComidaRepositorio comidaRepositorio;

    // READ
    public List<Comida> listarComidas(){return comidaRepositorio.findAll();}

    // CREATE
    public Comida crearComida(Comida request){
        if(comidaRepositorio.existsByNombre(request.getNombre())){
            throw new RuntimeException("La comida ya existe");
        }
        Comida comida = new Comida(request.getNombre(), request.getDescripcion(), request.getTipo(), request.getCalorias());
        return comidaRepositorio.save(comida);
    }

    // UPDATE
    public Comida editarComida(String nombre, Comida request){
        Comida comida = buscarComida(nombre);
        comidaRepositorio.delete(comida);
        return crearComida(request);
    }

    // DELETE
    public List<Comida> eliminarComida(String nombre){
        Comida comida = buscarComida(nombre);
        comidaRepositorio.delete(comida);
        return listarComidas();
    }

    public Comida buscarComida(String nombre){
        Optional<Comida> comida = comidaRepositorio.findByNombre(nombre);
        if(comida.isEmpty()){
            throw new RuntimeException("No se encontro la comida");
        }
        return comida.get();
    }
}
