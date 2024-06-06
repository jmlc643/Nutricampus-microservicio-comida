package com.upao.pe.microserviciodieta.serializers.hora_dieta;

import com.upao.pe.microserviciodieta.serializers.HoraDiaSerializer;
import com.upao.pe.microserviciodieta.serializers.dieta.DietaSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoraDietaSerializer {
    private int hora;
    private DietaSerializer dieta;
    private HoraDiaSerializer momentoDia;
}
