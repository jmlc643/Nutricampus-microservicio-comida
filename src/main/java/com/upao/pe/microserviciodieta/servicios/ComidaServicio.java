package com.upao.pe.microserviciodieta.servicios;



import com.upao.pe.microserviciodieta.modelos.Comida;
import com.upao.pe.microserviciodieta.modelos.DietaComida;
import com.upao.pe.microserviciodieta.repositorios.ComidaRepositorio;
import com.upao.pe.microserviciodieta.serializers.comida.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComidaServicio {

    @Autowired private ComidaRepositorio comidaRepositorio;

    // READ
    public List<ComidaSerializer> listarComidas(){return comidaRepositorio.findAll().stream().map(this::retornarComidaSerializer).toList();}

    // CREATE
    public ComidaSerializer crearComida(CrearComidaRequest request){
        if(comidaRepositorio.existsByNombre(request.getNombre())){
            throw new RuntimeException("La comida ya existe");
        }
        List<DietaComida> dietaComidas = new ArrayList<>();
        Comida comida = new Comida(null, request.getNombre(), request.getDescripcion(), request.getTipo(), request.getCalorias(), dietaComidas);
        return retornarComidaSerializer(comidaRepositorio.save(comida));
    }

    // UPDATE
    public ComidaSerializer editarComida(String nombre, EditarComidaRequest request){
        Comida comida = buscarComida(nombre);
        comida.setNombre(request.getNombre());
        comida.setDescripcion(request.getDescripcion());
        comida.setTipo(request.getTipo());
        comida.setCalorias(comida.getCalorias());
        comida.setDietaComidas(request.getDietaComidas());
        comidaRepositorio.saveAndFlush(comida);
        return retornarComidaSerializer(comida);
    }

    // DELETE
    public List<ComidaSerializer> eliminarComida(String nombre){
        Comida comida = buscarComida(nombre);
        comidaRepositorio.delete(comida);
        return listarComidas();
    }

    // Mapear a Serializer
    public ComidaSerializer retornarComidaSerializer(Comida comida){
        return new ComidaSerializer(comida.getNombre(), comida.getDescripcion(), comida.getTipo(), comida.getCalorias());
    }

    public Comida buscarComida(String nombre){
        Optional<Comida> comida = comidaRepositorio.findByNombre(nombre);
        if(comida.isEmpty()){
            throw new RuntimeException("No se encontro la comida");
        }
        return comida.get();
    }
}
