package com.upao.pe.microserviciodieta.serializers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upao.pe.microserviciodieta.modelos.Dieta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "dieta_cronograma")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DietaCronograma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dieta_cronograma")
    private Long idDietaCronograma;

    @JsonIgnore
    private Long idCronogramaSemanal;

    @ManyToOne
    @JoinColumn(name = "id_dieta", nullable = false)
    private Dieta dieta;
}
