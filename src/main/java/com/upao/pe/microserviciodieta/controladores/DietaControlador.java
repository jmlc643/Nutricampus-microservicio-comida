package com.upao.pe.microserviciodieta.controladores;

import com.upao.pe.microserviciodieta.serializers.dieta.CrearDietaRequest;
import com.upao.pe.microserviciodieta.serializers.dieta.DietaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.EditarDietaRequest;
import com.upao.pe.microserviciodieta.servicios.DietaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("dieta")
//@CrossOrigin
public class DietaControlador {

    @Autowired private DietaServicio dietaServicio;

    @Autowired private RestTemplate restTemplate;

    @GetMapping("/listar/")
    public List<DietaSerializer> listarDietas(){
        return dietaServicio.listarDietas();
    }

    @PostMapping("/crear/")
    public DietaSerializer crearDieta(@RequestBody CrearDietaRequest request){
        return dietaServicio.crearDieta(request);
    }

    @PutMapping("/editar/")
    public DietaSerializer editarDieta(@RequestBody EditarDietaRequest request){
        return dietaServicio.editarDieta(request);
    }

    @DeleteMapping("/eliminar/")
    public List<DietaSerializer> eliminarDieta(@RequestBody Long id){
        return dietaServicio.eliminarDieta(id);
    }

    @GetMapping("/test/")
    public Object getApi(){
        return restTemplate.getForObject("http://localhost:8080/comida/listar/", Object.class);
    }
}
