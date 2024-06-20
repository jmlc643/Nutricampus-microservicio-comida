package com.upao.pe.microserviciodieta.serializers.dieta;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CrearDietaRequest {
    private double caloriasTotales;
    private List<ComidaConFechasCrear> comidas;
}
