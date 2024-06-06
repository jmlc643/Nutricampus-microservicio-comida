package com.upao.pe.microserviciodieta.serializers.dieta;

import com.upao.pe.microserviciodieta.serializers.ComidaSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DietaSerializer {
    private int raciones;
    private Object comida;
}
