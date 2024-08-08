package com.microservice.prestamo.service;

import com.microservice.prestamo.entities.Prestamo;
import com.microservice.prestamo.http.response.ClientByPrestamoResponse;

import java.util.List;

public interface IPrestamoService {

    // Método para obtener una lista de todos los préstamos
    List<Prestamo> findAll();

    // Método para encontrar un préstamo por su ID
    Prestamo findById(Long id);

    // Método para guardar un nuevo préstamo
    void save(Prestamo prestamo);

    // Método para actualizar un préstamo existente
    void update(Prestamo prestamo);

    // Método para eliminar un préstamo por su ID
    void delete(Long id);

    // Método para buscar préstamos por un identificador específico de préstamo
    List<Prestamo> findByPrestamoId(Long prestamoId);

    // Método para mostrar la comunicación
    ClientByPrestamoResponse findClientsByPrestamoId(Long prestamoId);
}
