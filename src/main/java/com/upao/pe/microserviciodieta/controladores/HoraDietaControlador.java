package com.upao.pe.microserviciodieta.controladores;

import com.upao.pe.microserviciodieta.modelos.HoraDieta;
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
    public List<HoraDieta> listarHoraDietas(){
        return horaDietaServicio.listarHoraDietas();
    }

    @PostMapping("/crear/")
    public HoraDieta crearHoraDieta(@RequestBody HoraDieta request){
        return horaDietaServicio.crearHoraDieta(request);
    }

    @DeleteMapping("/eliminar/")
    public List<HoraDieta> eliminarHoraDieta(@RequestBody Long id){
        return horaDietaServicio.eliminarHoraDieta(id);
    }
}
