package com.microservice.tarjeta.http.response;

import com.microservice.tarjeta.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientByTarjetaResponse {

    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private List<ClientDTO> clientDTOList;

}
