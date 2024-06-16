package com.upao.pe.microserviciodieta.serializers.comida;


import com.upao.pe.microserviciodieta.modelos.DietaComida;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ComidaSerializer {
    private String nombre;
    private String descripcion;
    private String tipo;
}
