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
        List<DietaComida> dietaComidas = new ArrayList<>();
        Comida comida = new Comida(null, request.getNombre(), request.getDescripcion(), request.getTipo(), dietaComidas);
        return retornarComidaSerializer(comidaRepositorio.save(comida));
    }

    // UPDATE
    public ComidaSerializer editarComida(EditarComidaRequest request){
        Optional<Comida> comida = comidaRepositorio.findByNombre(request.getNombre());
        if(comida.isEmpty()){
            throw new RuntimeException("No se encontro la comida");
        }
        comida.get().setNombre(request.getNuevoNombre());
        comida.get().setDescripcion(request.getDescripcion());
        comida.get().setTipo(request.getTipo());
        comida.get().setDietaComidas(request.getDietaComidas());
        comidaRepositorio.saveAndFlush(comida.get());
        return retornarComidaSerializer(comida.get());
    }

    // DELETE
    public List<ComidaSerializer> eliminarComida(EliminarComidaRequest request){
        Optional<Comida> comida = comidaRepositorio.findByNombre(request.getNombre());
        if(comida.isEmpty()){
            throw new RuntimeException("No se encontro la comida");
        }
        comidaRepositorio.delete(comida.get());
        return listarComidas();
    }

    // Mapear a Serializer
    public ComidaSerializer retornarComidaSerializer(Comida comida){
        return new ComidaSerializer(comida.getNombre(), comida.getDescripcion(), comida.getTipo());
    }

    public Comida buscarComida(BuscarComidaRequest request){
        Optional<Comida> comida = comidaRepositorio.findByNombre(request.getNombre());
        if(comida.isEmpty()){
            throw new RuntimeException("No se encontro la comida");
        }
        return comida.get();
    }
}
