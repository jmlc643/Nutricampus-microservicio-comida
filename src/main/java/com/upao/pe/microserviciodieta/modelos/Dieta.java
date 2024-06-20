package com.upao.pe.microserviciodieta.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upao.pe.microserviciodieta.serializers.DietaCronograma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dieta")
@Entity
public class Dieta {
    // calorias totales como atributo
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dieta")
    private Long idDieta;
    @Column(name = "calorias_totales")
    private double caloriasTotales;
    @OneToMany(mappedBy = "dieta", cascade = CascadeType.ALL)
    private List<DietaComida> dietaComidas;
    @OneToMany(mappedBy = "dieta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DietaCronograma> dietaCronogramas;
}