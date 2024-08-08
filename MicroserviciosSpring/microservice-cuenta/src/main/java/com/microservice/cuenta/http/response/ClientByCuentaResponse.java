package com.microservice.cuenta.http.response;

import com.microservice.cuenta.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientByCuentaResponse {

    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldo;
    private List<ClientDTO> clientDTOList;

}
