package com.microservice.prestamo.http.response;

import com.microservice.prestamo.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientByPrestamoResponse {

    private String numeroPrestamo;
    private Double monto;
    private Double tasaInteres;
    private Integer plazo;
    private String estado;
    private String nombreBanco; // Nombre del banco donde se realizó el préstamo
    private List<ClientDTO> clientDTOList;

}
