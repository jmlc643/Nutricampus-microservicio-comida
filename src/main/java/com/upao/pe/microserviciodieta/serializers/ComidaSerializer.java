package com.upao.pe.microserviciodieta.serializers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComidaSerializer {
    private String nombre;
    private String descripcion;
    private String tipo;
    private IngredienteSerializer ingrediente;
}
