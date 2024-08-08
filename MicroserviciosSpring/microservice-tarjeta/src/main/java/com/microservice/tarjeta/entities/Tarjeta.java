package com.microservice.tarjeta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "tarjetas")
@AllArgsConstructor
@NoArgsConstructor
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroTarjeta;

    private String nombreTitular;

    private String fechaExpiracion;

}
