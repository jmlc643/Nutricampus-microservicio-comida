package com.upao.pe.microserviciodieta.serializers.comida;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrearComidaRequest {
    private String nombre;
    private String descripcion;
    private String tipo;
}
