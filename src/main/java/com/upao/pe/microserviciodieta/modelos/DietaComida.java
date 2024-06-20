package com.upao.pe.microserviciodieta.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "dieta_comida")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietaComida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dieta_comida")
    private Long idDietaComida;
    @Column(name = "raciones", nullable = false)
    private int raciones;

    @ManyToOne
    @JoinColumn(name = "id_dieta", nullable = false)
    @JsonIgnore
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "id_comida", nullable = false)
    private Comida comida;

    @ManyToOne
    @JoinColumn(name = "id_hora_dia", nullable = false)
    private HoraDia horaDia;
}