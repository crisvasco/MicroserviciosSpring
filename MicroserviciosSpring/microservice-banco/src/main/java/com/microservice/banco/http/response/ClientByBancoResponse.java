package com.microservice.banco.http.response;

import com.microservice.banco.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ClientByBancoResponse {

    private String bancoName;
    private String address;
    private List<ClientDTO> clientDTOList;

}
