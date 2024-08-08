package com.microservice.dinero.service;

import com.microservice.dinero.client.ClientClient;
import com.microservice.dinero.dto.ClientDTO;
import com.microservice.dinero.entities.Dinero;
import com.microservice.dinero.http.response.ClientByDineroResponse;
import com.microservice.dinero.persistence.DineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DineroService implements IDineroService {

    @Autowired
    private DineroRepository dineroRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Dinero> findAll() {
        return (List<Dinero>) dineroRepository.findAll();
    }

    @Override
    public Dinero findById(Long id) {
        return dineroRepository.findById(id).orElseThrow(() -> new RuntimeException("Dinero not found"));
    }

    @Override
    public void save(Dinero dinero) {
        dineroRepository.save(dinero);
    }

    @Override
    public void update(Dinero dinero) {
        if (dinero.getId() != null && dineroRepository.existsById(dinero.getId())) {
            dineroRepository.save(dinero);
        } else {
            throw new RuntimeException("Dinero not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        dineroRepository.deleteById(id);
    }

    @Override
    public List<Dinero> findByDineroId(Long dineroId) {
        return dineroRepository.findById(dineroId).map(List::of).orElseThrow(() -> new RuntimeException("Dinero not found"));
    }

    @Override
    public ClientByDineroResponse findClientsByDineroId(Long dineroId) {
        // Consultar el registro de dinero
        Dinero dinero = dineroRepository.findById(dineroId).orElse(new Dinero());
        // Obtener los clientes
        List<ClientDTO> clientDTOList = clientClient.findAllClientByDinero(dineroId);

        return ClientByDineroResponse.builder()
                .cantidad(dinero.getCantidad())
                .tipoMoneda(dinero.getTipoMoneda())
                .clientDTOList(clientDTOList)
                .build();

    }
}
