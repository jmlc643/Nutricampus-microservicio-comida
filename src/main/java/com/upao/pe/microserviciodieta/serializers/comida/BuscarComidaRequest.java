package com.upao.pe.microserviciodieta.serializers.comida;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuscarComidaRequest {
    private String nombre;
}
