package com.upao.pe.microserviciodieta.controladores;


import com.upao.pe.microserviciodieta.modelos.HoraDia;
import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import com.upao.pe.microserviciodieta.servicios.HoraDiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hora-dia")
@CrossOrigin(origins = "http://localhost:4200")
public class HoraDiaControlador {
    @Autowired private HoraDiaServicio horaDiaServicio;

    @GetMapping("/listar/")
    public List<HoraDiaSerializer> listarHoraDias(){
        return horaDiaServicio.listarHoraDias();
    }

    @PostMapping("/crear/")
    public HoraDiaSerializer crearHoraDia(@RequestBody HoraDiaSerializer request){
        return horaDiaServicio.crearHoraDia(request);
    }

    @PutMapping("/editar/{id}")
    public HoraDiaSerializer editarHoraDia(@PathVariable Long id, @RequestBody HoraDiaSerializer request){
        return horaDiaServicio.editarHoraDia(id, request);
    }

    @DeleteMapping("/eliminar/{id}")
    public List<HoraDiaSerializer> eliminarHoraDia(@PathVariable Long id){
        return horaDiaServicio.eliminarHoraDia(id);
    }

}
