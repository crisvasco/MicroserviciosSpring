package com.microservice.tarjeta.service;

import com.microservice.tarjeta.entities.Tarjeta;
import com.microservice.tarjeta.http.response.ClientByTarjetaResponse;

import java.util.List;

public interface ITarjetaService {

    // Método para obtener una lista de todas las tarjetas
    List<Tarjeta> findAll();

    // Método para encontrar una tarjeta por su ID
    Tarjeta findById(Long id);

    // Método para guardar una nueva tarjeta
    void save(Tarjeta tarjeta);

    // Método para actualizar una tarjeta existente
    void update(Tarjeta tarjeta);

    // Método para eliminar una tarjeta por su ID
    void delete(Long id);

    // Método para buscar tarjetas por un identificador específico de tarjeta
    List<Tarjeta> findByTarjetaId(Long tarjetaId);

    // Método para mostrar la comunicación
    ClientByTarjetaResponse findClientsByTarjetaId(Long tarjetaId);
}
