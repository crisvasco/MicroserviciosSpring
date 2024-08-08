package com.microservice.notificacion.client;

import com.microservice.notificacion.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-client", url="localhost:8090/api/v1/client")
public interface ClientClient {

    @GetMapping("/search_by_notificacion/{notificacionId}")
    List<ClientDTO> findAllClientByNotificacion(@PathVariable Long notificacionId);
}
