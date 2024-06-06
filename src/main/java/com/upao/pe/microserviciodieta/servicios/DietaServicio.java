package com.upao.pe.microserviciodieta.servicios;


import com.upao.pe.microserviciodieta.modelos.Dieta;
import com.upao.pe.microserviciodieta.repositorios.DietaRepositorio;
import com.upao.pe.microserviciodieta.serializers.Comida;
import com.upao.pe.microserviciodieta.serializers.dieta.CrearDietaRequest;
import com.upao.pe.microserviciodieta.serializers.dieta.DietaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.EditarDietaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DietaServicio {

    @Autowired
    private DietaRepositorio dietaRepositorio;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${comida.service.url}")
    private String url;

    // READ
    public List<DietaSerializer> listarDietas(){return dietaRepositorio.findAll().stream().map((it) ->{
        Comida comida = restTemplate.getForObject(url+"/comida/"+it.getIdComida()+"/", Comida.class);
        return retornarDietaSerializer(it, comida);
    }).toList();}

    // CREATE
    public DietaSerializer crearDieta(CrearDietaRequest request){
        Comida comida = restTemplate.getForObject(url+"/comida/"+request.getIdComida()+"/", Comida.class);
        Dieta dieta = new Dieta(null, request.getRaciones(), comida.getIdComida());
        return retornarDietaSerializer(dietaRepositorio.save(dieta), comida);
    }

    // UPDATE
    public DietaSerializer editarDieta(EditarDietaRequest request){
        Optional<Dieta> dieta = dietaRepositorio.findById(request.getId());
        if(dieta.isEmpty()){
            throw new RuntimeException("No se encontro la dieta");
        }
        Comida comida = restTemplate.getForObject(url+"/comida/"+request.getNombreComida()+"/", Comida.class);
        dieta.get().setRaciones(request.getRaciones());
        dieta.get().setIdComida(comida.getIdComida());
        dietaRepositorio.saveAndFlush(dieta.get());
        return retornarDietaSerializer(dieta.get(), comida);
    }

    // DELETE
    public List<DietaSerializer> eliminarDieta(Long id){
        Optional<Dieta> dieta = dietaRepositorio.findById(id);
        if(dieta.isEmpty()){
            throw new RuntimeException("No se encontro la dieta");
        }
        dietaRepositorio.delete(dieta.get());
        return listarDietas();
    }

    // Mapear a Serializer
    public DietaSerializer retornarDietaSerializer(Dieta dieta, Comida comida){
        Object comidaDTO = restTemplate.postForObject(url+"/comida/retornarSerializer/", comida, Object.class);
        return new DietaSerializer(dieta.getRaciones(), comidaDTO);
    }
}
