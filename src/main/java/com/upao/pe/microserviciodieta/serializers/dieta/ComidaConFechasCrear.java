package com.upao.pe.microserviciodieta.serializers.dieta;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ComidaConFechasCrear {
    private String comida;
    private LocalDateTime fecha;
}
