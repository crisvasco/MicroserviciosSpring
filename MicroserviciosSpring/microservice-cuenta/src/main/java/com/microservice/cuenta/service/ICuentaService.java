package com.microservice.cuenta.service;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.http.response.ClientByCuentaResponse;

import java.util.List;

public interface ICuentaService {

    // Método para obtener una lista de todas las cuentas
    List<Cuenta> findAll();

    // Método para encontrar una cuenta por su ID
    Cuenta findById(Long id);

    // Método para guardar una nueva cuenta
    void save(Cuenta cuenta);

    // Método para actualizar una cuenta existente
    void update(Cuenta cuenta);

    // Método para eliminar una cuenta por su ID
    void delete(Long id);

    // Método para buscar cuentas por un identificador específico de cuenta
    List<Cuenta> findByCuentaId(Long cuentaId);

    // Mostrar la comunicación de clientes por ID de cuenta
    ClientByCuentaResponse findClientsByCuentaId(Long cuentaId);
}
