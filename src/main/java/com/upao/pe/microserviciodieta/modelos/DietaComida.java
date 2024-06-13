package com.upao.pe.microserviciodieta.modelos;

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

    @ManyToOne
    @JoinColumn(name = "id_dieta", nullable = false)
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "id_comida", nullable = false)
    private Comida comida;
}