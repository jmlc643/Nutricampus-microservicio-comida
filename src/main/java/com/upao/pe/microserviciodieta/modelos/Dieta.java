package com.upao.pe.microserviciodieta.modelos;

import com.upao.pe.microserviciodieta.serializers.Comida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dieta")
@Entity
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dieta")
    private Long idDieta;
    @Column(name = "raciones", nullable = false)
    private int raciones;
    @Column(name = "id_comida", nullable = false)
    private Long idComida;
}