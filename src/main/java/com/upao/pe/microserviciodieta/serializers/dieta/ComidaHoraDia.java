package com.upao.pe.microserviciodieta.serializers.dieta;

import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import com.upao.pe.microserviciodieta.serializers.comida.ComidaSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComidaHoraDia {
    private int raciones;
    private ComidaSerializer comida;
    private HoraDiaSerializer fecha;
}
