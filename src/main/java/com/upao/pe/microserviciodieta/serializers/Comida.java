package com.upao.pe.microserviciodieta.serializers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comida {
    private Long idComida;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Ingrediente ingrediente;
}
