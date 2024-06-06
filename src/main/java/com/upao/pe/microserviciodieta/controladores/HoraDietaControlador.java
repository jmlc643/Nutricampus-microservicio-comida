package com.upao.pe.microserviciodieta.controladores;

import com.upao.pe.microserviciodieta.modelos.HoraDieta;
import com.upao.pe.microserviciodieta.serializers.hora_dieta.CrearHoraDietaSerializer;
import com.upao.pe.microserviciodieta.serializers.hora_dieta.HoraDietaSerializer;
import com.upao.pe.microserviciodieta.servicios.HoraDietaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hora-dieta")
//@CrossOrigin
public class HoraDietaControlador {

    @Autowired private HoraDietaServicio horaDietaServicio;

    @GetMapping("/listar/")
    public List<HoraDietaSerializer> listarHoraDietas(){
        return horaDietaServicio.listarHoraDietas();
    }

    @PostMapping("/crear/")
    public HoraDietaSerializer crearHoraDieta(@RequestBody CrearHoraDietaSerializer request){
        return horaDietaServicio.crearHoraDieta(request);
    }

    @DeleteMapping("/eliminar/")
    public List<HoraDietaSerializer> eliminarHoraDieta(@RequestBody Long id){
        return horaDietaServicio.eliminarHoraDieta(id);
    }

    @GetMapping("/{id}/")
    public HoraDieta buscarHoraDietaPorId(@PathVariable Long id){return horaDietaServicio.buscarHoraDietaPorId(id);}

    @PostMapping("/retornarSerializer/")
    public HoraDietaSerializer retornarSerializer(@RequestBody HoraDieta horaDieta){
        return horaDietaServicio.retornarHoraDietaSerializer(horaDieta);
    }
}
