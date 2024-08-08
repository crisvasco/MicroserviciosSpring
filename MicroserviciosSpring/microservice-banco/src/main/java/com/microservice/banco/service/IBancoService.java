package com.microservice.banco.service;

import com.microservice.banco.entities.Banco;
import com.microservice.banco.http.response.ClientByBancoResponse;

import java.util.List;

public interface IBancoService {

    // Método para obtener una lista de todos los bancos
    List<Banco> findAll();

    // Método para encontrar un banco por su ID
    Banco findById(Long id);

    // Método para guardar un nuevo banco
    void save(Banco banco);

    // Método para actualizar un banco existente
    void update(Banco banco);

    // Método para eliminar un banco por su ID
    void delete(Long id);

    // Método para buscar bancos por un identificador específico de banco
    List<Banco> findByBancoId(Long bancoId);

    //MOSTAR LA COMUNICACION
    ClientByBancoResponse findClientsByBancoId(Long bancoId);
}
