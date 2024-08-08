package com.microservice.dinero.service;

import com.microservice.dinero.entities.Dinero;
import com.microservice.dinero.http.response.ClientByDineroResponse;

import java.util.List;

public interface IDineroService {

    // Método para obtener una lista de todos los registros de dinero
    List<Dinero> findAll();

    // Método para encontrar un registro de dinero por su ID
    Dinero findById(Long id);

    // Método para guardar un nuevo registro de dinero
    void save(Dinero dinero);

    // Método para actualizar un registro de dinero existente
    void update(Dinero dinero);

    // Método para eliminar un registro de dinero por su ID
    void delete(Long id);

    // Método para buscar registros de dinero por un identificador específico
    List<Dinero> findByDineroId(Long dineroId);

    // Mostrar la comunicación relacionada con el dinero
    ClientByDineroResponse findClientsByDineroId(Long dineroId);
}
