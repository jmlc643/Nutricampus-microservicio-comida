package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.Comida;
import com.upao.pe.microserviciodieta.modelos.Dieta;
import com.upao.pe.microserviciodieta.modelos.DietaComida;
import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.repositorios.DietaRepositorio;
import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import com.upao.pe.microserviciodieta.serializers.comida.ComidaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.*;
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

    @Autowired private HoraDiaServicio horaDiaServicio;

    // READ
    public List<DietaSerializer> listarDietas(){return dietaRepositorio.findAll().stream().map(this::retornarDietaSerializer).toList();}

    // CREATE
    public DietaSerializer crearDieta(CrearDietaRequest request){
        Dieta dieta = new Dieta(null, request.getRaciones(), null);
        dietaRepositorio.save(dieta);
        // Generar la lista de la tabla intermedia DietaComida
        List<DietaComida> dietaComidas = new ArrayList<>();

        for(ComidaConFechasCrear comidaConFecha : request.getComidas()){
            Comida comida = comidaServicio.buscarComida(comidaConFecha.getComida());
            HoraDia horaDia = horaDiaServicio.buscarHoraDiaPorFechaYHora(comidaConFecha.getFecha().toLocalDate(), comidaConFecha.getFecha().toLocalTime());
            DietaComida dietaComida = new DietaComida(null, dieta, comida, horaDia);
            dietaComidas.add(dietaComida);
        }

        // Editar dieta guardada
        dieta.setDietaComidas(dietaComidas);
        dietaRepositorio.saveAndFlush(dieta);
        return retornarDietaSerializer(dieta);
    }

    // UPDATE
    public DietaSerializer editarDieta(Long id, EditarDietaRequest request){
        Dieta dieta = buscarDieta(id);
        dieta.setRaciones(request.getRaciones());
        dieta.setDietaComidas(request.getDietaComidas());
        dietaRepositorio.saveAndFlush(dieta);
        return retornarDietaSerializer(dieta);
    }

    // DELETE
    public List<DietaSerializer> eliminarDieta(Long id){
        Dieta dieta = buscarDieta(id);
        dietaRepositorio.delete(dieta);
        return listarDietas();
    }

    // Mapear a Serializer
    public DietaSerializer retornarDietaSerializer(Dieta dieta){
        List<ComidaHoraDia> comidas = new ArrayList<>();
        for(int i = 0; i < dieta.getDietaComidas().size(); i++) {
            ComidaHoraDia comidaConFecha = new ComidaHoraDia(comidaServicio.retornarComidaSerializer(dieta.getDietaComidas().get(i).getComida()), horaDiaServicio.retornarHoraDiaSerializer(dieta.getDietaComidas().get(i).getHoraDia()));
            comidas.add(comidaConFecha);
        }
        return new DietaSerializer(dieta.getRaciones(), comidas);
    }

    public Dieta buscarDieta(Long id){
        Optional<Dieta> dieta = dietaRepositorio.findById(id);
        if(dieta.isEmpty()){
            throw new RuntimeException("No se ha encontrado la dieta");
        }
        return dieta.get();
    }
}
