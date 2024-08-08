package com.microservice.client.service;

import com.microservice.client.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    Client findById(Long id);

    void save(Client client);

    void update(Client client);

    void delete(Long id);

    List<Client> findByIdBanco(Long idBanco);

    List<Client> findByIdCuenta(Long idCuenta);

    List<Client> findByIdTarjeta(Long idTarjeta);

    List<Client> findByIdPrestamo(Long idPrestamo);

    List<Client> findByIdNotificacion(Long idNotificacion);

    List<Client> findByIdDinero(Long idDinero);

}
