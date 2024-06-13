package com.upao.pe.microserviciodieta.serializers.dieta;

import com.upao.pe.microserviciodieta.modelos.DietaComida;
import com.upao.pe.microserviciodieta.serializers.comida.ComidaSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DietaSerializer {
    private int raciones;
    private List<DietaComida> dietaComidas;
}
