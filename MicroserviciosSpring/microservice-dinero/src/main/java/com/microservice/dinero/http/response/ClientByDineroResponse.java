package com.microservice.dinero.http.response;

import com.microservice.dinero.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientByDineroResponse {

    private String tipoMoneda;
    private Double cantidad;
    private List<ClientDTO> clientDTOList;

}
