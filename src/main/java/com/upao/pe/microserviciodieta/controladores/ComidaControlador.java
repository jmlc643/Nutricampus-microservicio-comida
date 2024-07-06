package com.upao.pe.microserviciodieta.controladores;

import com.upao.pe.microserviciodieta.modelos.Comida;
import com.upao.pe.microserviciodieta.servicios.ComidaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comida")
@CrossOrigin("https://angular-nutri-campus.vercel.app")
public class ComidaControlador {
    @Autowired private ComidaServicio comidaServicio;

    @GetMapping("/listar/")
    public List<Comida> listarComidas(){
        return comidaServicio.listarComidas();
    }

    @PostMapping("/crear/")
    public Comida crearComida(@RequestBody Comida request){
        return comidaServicio.crearComida(request);
    }

    @PutMapping("/editar/{nombre}")
    public Comida editarComida(@PathVariable String nombre, @RequestBody Comida request){
        return comidaServicio.editarComida(nombre, request);
    }

    @DeleteMapping("/eliminar/{nombre}")
    public List<Comida> eliminarComida(@PathVariable String nombre){
        return comidaServicio.eliminarComida(nombre);
    }

    @GetMapping("/buscar/{nombre}")
    public Comida buscarComida(@PathVariable String nombre){
        return comidaServicio.buscarComida(nombre);
    }
}
