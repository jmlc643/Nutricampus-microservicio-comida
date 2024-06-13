package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.Dieta;
import com.upao.pe.microserviciodieta.modelos.DietaComida;
import com.upao.pe.microserviciodieta.repositorios.DietaRepositorio;
import com.upao.pe.microserviciodieta.serializers.dieta.CrearDietaRequest;
import com.upao.pe.microserviciodieta.serializers.dieta.DietaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.EditarDietaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DietaServicio {

    @Autowired
    private DietaRepositorio dietaRepositorio;
    @Autowired private ComidaServicio comidaServicio;

    // READ
    public List<DietaSerializer> listarDietas(){return dietaRepositorio.findAll().stream().map(this::retornarDietaSerializer).toList();}

    // CREATE
    public DietaSerializer crearDieta(CrearDietaRequest request){
        List<DietaComida> dietaComidas = new ArrayList<>();
        Dieta dieta = new Dieta(null, request.getRaciones(), dietaComidas);
        return retornarDietaSerializer(dietaRepositorio.save(dieta));
    }

    // UPDATE
    public DietaSerializer editarDieta(EditarDietaRequest request){
        Optional<Dieta> dieta = dietaRepositorio.findById(request.getId());
        if(dieta.isEmpty()){
            throw new RuntimeException("No se encontro la dieta");
        }
        dieta.get().setRaciones(request.getRaciones());
        dieta.get().setDietaComidas(request.getDietaComidas());
        dietaRepositorio.saveAndFlush(dieta.get());
        return retornarDietaSerializer(dieta.get());
    }

    // DELETE
    public List<DietaSerializer> eliminarDieta(Long id){
        Optional<Dieta> dieta = dietaRepositorio.findById(id);
        if(dieta.isEmpty()){
            throw new RuntimeException("No se encontro la dieta");
        }
        dietaRepositorio.delete(dieta.get());
        return listarDietas();
    }

    // Mapear a Serializer
    public DietaSerializer retornarDietaSerializer(Dieta dieta){
        return new DietaSerializer(dieta.getRaciones(), dieta.getDietaComidas());
    }

    public Dieta buscarDieta(Long id){
        Optional<Dieta> dieta = dietaRepositorio.findById(id);
        if(dieta.isEmpty()){
            throw new RuntimeException("No se ha encontrado la dieta");
        }
        return dieta.get();
    }
}
