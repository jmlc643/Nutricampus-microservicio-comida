package com.upao.pe.microserviciodieta.serializers.dieta;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CrearDietaRequest {
    private int raciones;
    private List<ComidaConFechasCrear> comidas;
}
