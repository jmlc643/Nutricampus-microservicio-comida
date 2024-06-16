package com.upao.pe.microserviciodieta.controladores;

import com.upao.pe.microserviciodieta.serializers.dieta.CrearDietaRequest;
import com.upao.pe.microserviciodieta.serializers.dieta.DietaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.EditarDietaRequest;
import com.upao.pe.microserviciodieta.servicios.DietaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("dieta")
@CrossOrigin(origins = "http://localhost:4200")
public class DietaControlador {

    @Autowired private DietaServicio dietaServicio;

    @GetMapping("/listar/")
    public List<DietaSerializer> listarDietas(){
        return dietaServicio.listarDietas();
    }

    @PostMapping("/crear/")
    public DietaSerializer crearDieta(@RequestBody CrearDietaRequest request){
        return dietaServicio.crearDieta(request);
    }

    @PutMapping("/editar/{id}")
    public DietaSerializer editarDieta(@PathVariable Long id, @RequestBody EditarDietaRequest request){
        return dietaServicio.editarDieta(id, request);
    }

    @DeleteMapping("/eliminar/{id}")
    public List<DietaSerializer> eliminarDieta(@PathVariable Long id){
        return dietaServicio.eliminarDieta(id);
    }
}
