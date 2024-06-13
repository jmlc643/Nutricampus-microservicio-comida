package com.upao.pe.microserviciodieta.serializers.comida;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EliminarComidaRequest {
    private String nombre;
}
