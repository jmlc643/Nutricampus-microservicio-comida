package com.upao.pe.microserviciodieta.serializers.comida;

import com.upao.pe.microserviciodieta.modelos.DietaComida;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class EditarComidaRequest {
    private String nombre;
    private String descripcion;
    private String tipo;
    private double calorias;
    private List<DietaComida> dietaComidas;
}
