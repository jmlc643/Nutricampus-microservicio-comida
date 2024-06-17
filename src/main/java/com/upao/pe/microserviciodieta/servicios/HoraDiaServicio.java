package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.repositorios.HoraDiaRepositorio;
import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HoraDiaServicio {

    @Autowired
    HoraDiaRepositorio horaDiaRepositorio;

    // READ
    public List<HoraDiaSerializer> listarHoraDias(){return horaDiaRepositorio.findAll().stream().map(this::retornarHoraDiaSerializer).toList();}

    // CREATE
    public HoraDiaSerializer crearHoraDia(HoraDiaSerializer request){
        HoraDia horaDia = new HoraDia(null, request.getFecha(), request.getHora(), new ArrayList<>(), new ArrayList<>());
        return retornarHoraDiaSerializer(horaDiaRepositorio.save(horaDia));
    }

    //UPDATE
    public HoraDiaSerializer editarHoraDia(Long id, HoraDiaSerializer request){
        HoraDia horaDia = buscarHoraDia(id);
        horaDia.setHora(request.getHora());
        horaDiaRepositorio.saveAndFlush(horaDia);
        return retornarHoraDiaSerializer(horaDia);
    }

    // DELETE
    public List<HoraDiaSerializer> eliminarHoraDia(Long id){
        HoraDia horaDia = buscarHoraDia(id);
        horaDiaRepositorio.delete(horaDia);
        return listarHoraDias();
    }

    // Mapear a serializer
    public HoraDiaSerializer retornarHoraDiaSerializer(HoraDia horaDia){
        return new HoraDiaSerializer(horaDia.getFecha(), horaDia.getHora());
    }

    public HoraDia buscarHoraDia(Long id) {
        Optional<HoraDia> horaDia = horaDiaRepositorio.findById(id);
        if(horaDia.isEmpty()){
            throw new RuntimeException(("No se encuentra la hora del dia"));
        }
        return horaDia.get();
    }

    public HoraDia buscarHoraDiaPorFechaYHora(LocalDate fecha, LocalTime hora){
        Optional<HoraDia> horaDia = horaDiaRepositorio.findByFechaAndHora(fecha, hora);
        if(horaDia.isEmpty()){
            throw new RuntimeException(("No se encuentra la hora del dia"));
        }
        return horaDia.get();
    }

}
