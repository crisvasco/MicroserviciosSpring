package com.microservice.client.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name="last_name")
    private String lastName;

    private String email;

    private String phone;

    @Column(name = "banco_id")
    private Long bancoId;

    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Column(name = "tarjeta_id")
    private Long tarjetaId;

    @Column(name = "prestamo_id")
    private Long prestamoId;

    @Column(name = "notificacion_id")
    private Long notificacionId;

    @Column(name = "dinero_id")
    private Long dineroId;
}
