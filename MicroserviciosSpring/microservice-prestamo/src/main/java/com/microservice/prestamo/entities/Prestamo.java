package com.microservice.prestamo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "prestamos")
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPrestamo;

    private Double monto;

    private Double tasaInteres;

    private Integer plazo;

    private String estado;


    private String nombreBanco; // Nombre del banco donde se realizó el préstamo

}
