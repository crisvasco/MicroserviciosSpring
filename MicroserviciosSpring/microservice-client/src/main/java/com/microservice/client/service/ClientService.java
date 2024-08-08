package com.microservice.client.service;

import com.microservice.client.entities.Client;
import com.microservice.client.persistence.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Client client) {
      clientRepository.save(client);
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Client> findByIdBanco(Long idBanco) {
        return clientRepository.findAllByBancoId(idBanco);
    }

    @Override
    public List<Client> findByIdCuenta(Long idCuenta) {
        return clientRepository.findAllByCuentaId(idCuenta);
    }

    @Override
    public List<Client> findByIdTarjeta(Long idTarjeta) {
        return clientRepository.findAllByTarjetaId(idTarjeta);
    }

    @Override
    public List<Client> findByIdPrestamo(Long idPrestamo) {
        return clientRepository.findAllByPrestamoId(idPrestamo);
    }

    @Override
    public List<Client> findByIdNotificacion(Long idNotificacion) {
        return clientRepository.findAllByNotificacionId(idNotificacion);
    }

    @Override
    public List<Client> findByIdDinero(Long idDinero) {
        return clientRepository.findAllByDineroId(idDinero);
    }
}
