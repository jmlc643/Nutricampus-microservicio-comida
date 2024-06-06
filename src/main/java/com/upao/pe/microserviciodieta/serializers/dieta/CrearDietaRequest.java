package com.upao.pe.microserviciodieta.serializers.dieta;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CrearDietaRequest {
    private int raciones;
    private Long idComida;
}
