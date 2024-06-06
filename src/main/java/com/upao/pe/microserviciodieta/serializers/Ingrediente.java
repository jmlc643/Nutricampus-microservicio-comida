package com.upao.pe.microserviciodieta.serializers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private Long idIngrediente;
    private String nombre;
    private double cantidad;
    private String unidad;
    private double caloriasUnidad;
}
