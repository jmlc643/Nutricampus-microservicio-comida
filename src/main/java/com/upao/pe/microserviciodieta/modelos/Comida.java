package com.upao.pe.microserviciodieta.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comidas")
public class Comida {
    @Id
    private String nombre;
    private String descripcion;
    private String tipo;
    private double calorias;
}
