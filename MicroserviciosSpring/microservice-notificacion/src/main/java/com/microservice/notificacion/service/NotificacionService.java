package com.microservice.notificacion.service;

import com.microservice.notificacion.client.ClientClient;
import com.microservice.notificacion.dto.ClientDTO;
import com.microservice.notificacion.entities.Notificacion;
import com.microservice.notificacion.http.response.ClientByNotificacionResponse;
import com.microservice.notificacion.persistence.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService implements INotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Notificacion> findAll() {
        return (List<Notificacion>) notificacionRepository.findAll();
    }

    @Override
    public Notificacion findById(Long id) {
        return notificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Notificación not found"));
    }

    @Override
    public void save(Notificacion notificacion) {
        notificacionRepository.save(notificacion);
    }

    @Override
    public void update(Notificacion notificacion) {
        if (notificacion.getId() != null && notificacionRepository.existsById(notificacion.getId())) {
            notificacionRepository.save(notificacion);
        } else {
            throw new RuntimeException("Notificación not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        notificacionRepository.deleteById(id);
    }

    @Override
    public List<Notificacion> findByNotificacionId(Long notificacionId) {
        return notificacionRepository.findById(notificacionId).map(List::of).orElseThrow(() -> new RuntimeException("Notificación not found"));
    }

    @Override
    public ClientByNotificacionResponse findClientsByNotificacionId(Long notificacionId) {
        // Consultar la notificación
        Notificacion notificacion = notificacionRepository.findById(notificacionId).orElse(new Notificacion());
        // Obtener los clientes
        List<ClientDTO> clientDTOList = clientClient.findAllClientByNotificacion(notificacionId);

        return ClientByNotificacionResponse.builder()
                .tipoNotificacion(notificacion.getTipoNotificacion())
                .mensaje(notificacion.getMensaje())
                .fecha(notificacion.getFecha())
                .clientDTOList(clientDTOList)
                .build();
    }
}
