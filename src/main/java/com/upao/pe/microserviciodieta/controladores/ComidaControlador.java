package com.upao.pe.microserviciodieta.controladores;


import com.upao.pe.microserviciodieta.modelos.Comida;
import com.upao.pe.microserviciodieta.serializers.comida.*;
import com.upao.pe.microserviciodieta.servicios.ComidaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comida")
@CrossOrigin(origins = "http://localhost:4200")
public class ComidaControlador {
    @Autowired private ComidaServicio comidaServicio;

    @GetMapping("/listar/")
    public List<ComidaSerializer> listarComidas(){
        return comidaServicio.listarComidas();
    }

    @PostMapping("/crear/")
    public ComidaSerializer crearComida(@RequestBody CrearComidaRequest request){
        return comidaServicio.crearComida(request);
    }

    @PutMapping("/editar/")
    public ComidaSerializer editarComida(@RequestBody EditarComidaRequest request){
        return comidaServicio.editarComida(request);
    }

    @DeleteMapping("/eliminar/")
    public List<ComidaSerializer> eliminarComida(@RequestBody EliminarComidaRequest request){
        return comidaServicio.eliminarComida(request);
    }
}
