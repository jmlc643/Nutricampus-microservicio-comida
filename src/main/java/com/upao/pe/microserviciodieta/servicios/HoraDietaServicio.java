package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.Dieta;
import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.modelos.HoraDieta;
import com.upao.pe.microserviciodieta.repositorios.HoraDietaRepositorio;
import com.upao.pe.microserviciodieta.serializers.hora_dieta.CrearHoraDietaSerializer;
import com.upao.pe.microserviciodieta.serializers.hora_dieta.HoraDietaSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HoraDietaServicio {

    @Autowired private HoraDietaRepositorio horaDietaRepositorio;
    @Autowired private DietaServicio dietaServicio;
    @Autowired private HoraDiaServicio horaDiaServicio;
    @Autowired private RestTemplate restTemplate;
    @Value("${comida.service.url}") private String url;

    // READ
    public List<HoraDietaSerializer> listarHoraDietas(){return horaDietaRepositorio.findAll().stream().map(this::retornarHoraDietaSerializer).toList();}

    // CREATE
    public HoraDietaSerializer crearHoraDieta(CrearHoraDietaSerializer request){
        HoraDia horaDia = horaDiaServicio.buscarHoraDia(request.getMomentoDia());
        Dieta dieta = dietaServicio.buscarDieta(request.getIdDieta());
        HoraDieta horaDieta =new HoraDieta(null, request.getHora(), dieta, horaDia);
        return retornarHoraDietaSerializer(horaDietaRepositorio.save(horaDieta));
    }

    // DELETE
    public List<HoraDietaSerializer> eliminarHoraDieta(Long id){
        HoraDieta horaDieta = buscarHoraDietaPorId(id);
        horaDietaRepositorio.delete(horaDieta);
        return listarHoraDietas();
    }

    public HoraDieta buscarHoraDietaPorId(Long id) {
        Optional<HoraDieta> horaDieta = horaDietaRepositorio.findById(id);
        if(horaDieta.isEmpty()){
            throw new RuntimeException("No se encuentra la hora de la dieta");
        }
        return horaDieta.get();
    }
    
    public HoraDietaSerializer retornarHoraDietaSerializer(HoraDieta horaDieta){
        Comida comida = restTemplate.getForObject(url+"/comida/"+horaDieta.getDieta().getIdComida()+"/", Comida.class);
        return new HoraDietaSerializer(horaDieta.getHora(), dietaServicio.retornarDietaSerializer(horaDieta.getDieta(), comida), horaDiaServicio.retornarHoraDiaSerializer(horaDieta.getHoraDia()));
    }
}
