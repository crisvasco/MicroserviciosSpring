package com.microservice.notificacion.service;

import com.microservice.notificacion.entities.Notificacion;
import com.microservice.notificacion.http.response.ClientByNotificacionResponse;

import java.util.List;

public interface INotificacionService {

    // Método para obtener una lista de todas las notificaciones
    List<Notificacion> findAll();

    // Método para encontrar una notificación por su ID
    Notificacion findById(Long id);

    // Método para guardar una nueva notificación
    void save(Notificacion notificacion);

    // Método para actualizar una notificación existente
    void update(Notificacion notificacion);

    // Método para eliminar una notificación por su ID
    void delete(Long id);

    // Método para buscar notificaciones por un identificador específico de notificación
    List<Notificacion> findByNotificacionId(Long notificacionId);

    // Mostrar la comunicación de clientes por ID de notificación
    ClientByNotificacionResponse findClientsByNotificacionId(Long notificacionId);
}
