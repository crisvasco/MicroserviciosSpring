package com.microservice.tarjeta.service;

import com.microservice.tarjeta.client.ClientClient;
import com.microservice.tarjeta.dto.ClientDTO;
import com.microservice.tarjeta.entities.Tarjeta;
import com.microservice.tarjeta.http.response.ClientByTarjetaResponse;
import com.microservice.tarjeta.persistence.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaService implements ITarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Tarjeta> findAll() {
        return (List<Tarjeta>) tarjetaRepository.findAll();
    }

    @Override
    public Tarjeta findById(Long id) {
        return tarjetaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarjeta not found"));
    }

    @Override
    public void save(Tarjeta tarjeta) {
        tarjetaRepository.save(tarjeta);
    }

    @Override
    public void update(Tarjeta tarjeta) {
        if (tarjeta.getId() != null && tarjetaRepository.existsById(tarjeta.getId())) {
            tarjetaRepository.save(tarjeta);
        } else {
            throw new RuntimeException("Tarjeta not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        tarjetaRepository.deleteById(id);
    }

    @Override
    public List<Tarjeta> findByTarjetaId(Long tarjetaId) {
        // Suponiendo que este método debería encontrar todas las tarjetas con el ID dado,
        // pero si no tiene sentido, necesitas definir el método apropiado en el repositorio.
        return tarjetaRepository.findById(tarjetaId).map(List::of).orElseThrow(() -> new RuntimeException("Tarjeta not found"));
    }

    @Override
    public ClientByTarjetaResponse findClientsByTarjetaId(Long tarjetaId) {
        // Consultar la tarjeta
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).orElse(new Tarjeta());
        // Obtener los clientes
        List<ClientDTO> clientDTOList = clientClient.findAllClientByTarjeta(tarjetaId);

        return ClientByTarjetaResponse.builder()
                .numeroTarjeta(tarjeta.getNumeroTarjeta())
                .nombreTitular(tarjeta.getNombreTitular())
                .fechaExpiracion(tarjeta.getFechaExpiracion())
                .clientDTOList(clientDTOList)
                .build();
    }
}
