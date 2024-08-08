package com.microservice.notificacion.http.response;

import com.microservice.notificacion.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientByNotificacionResponse {

    private String mensaje;
    private String tipoNotificacion;
    private String fecha;
    private List<ClientDTO> clientDTOList;

}
