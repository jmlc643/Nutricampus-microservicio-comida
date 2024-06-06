package com.upao.pe.microserviciodieta.serializers.hora_dieta;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CrearHoraDietaSerializer {
    private int hora;
    private Long idDieta;
    private String momentoDia;
}
