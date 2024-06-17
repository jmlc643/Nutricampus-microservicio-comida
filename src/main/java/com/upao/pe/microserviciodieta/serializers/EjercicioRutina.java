package com.upao.pe.microserviciodieta.serializers;

import com.upao.pe.microserviciodieta.modelos.HoraDia;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EjercicioRutina {
    @Id
    private Long idEjercicioRutina;
    private Long idRutina;
    private Long idEjercicio;
    @ManyToOne
    @JoinColumn(name = "id_hora_dia", nullable = false)
    private HoraDia horaDia;
}
