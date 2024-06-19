package com.upao.pe.microserviciodieta.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.upao.pe.microserviciodieta.serializers.EjercicioRutina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hora_dia")
@Entity
public class HoraDia {
    /*
    Fecha y Hora de Inicio y Fin
    Posiblemente 2 atributos LocalDateTime (Buscar(fechaInicio, fechaFin))
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hora_dia")
    private Long idHoraDia;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "hora", nullable = false)
    private LocalTime hora;
    @OneToMany(mappedBy = "horaDia", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DietaComida> dietaComidas;
    @OneToMany(mappedBy = "horaDia", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EjercicioRutina> ejercicioRutinas;
}