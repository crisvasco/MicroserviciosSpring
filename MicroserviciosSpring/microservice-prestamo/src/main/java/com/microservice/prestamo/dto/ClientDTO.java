package com.microservice.prestamo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientDTO {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Long bancoId;
    private Long cuentaId;
    private Long tarjetaId;
    private Long prestamoId;
    private Long notificacionId;
    private Long dineroId;
}
