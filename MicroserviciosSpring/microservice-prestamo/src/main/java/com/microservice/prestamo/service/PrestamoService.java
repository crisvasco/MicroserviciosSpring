package com.microservice.prestamo.service;

import com.microservice.prestamo.client.ClientClient;
import com.microservice.prestamo.dto.ClientDTO;
import com.microservice.prestamo.entities.Prestamo;
import com.microservice.prestamo.http.response.ClientByPrestamoResponse;
import com.microservice.prestamo.persistence.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Prestamo> findAll() {
        return (List<Prestamo>) prestamoRepository.findAll();
    }

    @Override
    public Prestamo findById(Long id) {
        return prestamoRepository.findById(id).orElseThrow(() -> new RuntimeException("Prestamo not found"));
    }

    @Override
    public void save(Prestamo prestamo) {
        prestamoRepository.save(prestamo);
    }

    @Override
    public void update(Prestamo prestamo) {
        if (prestamo.getId() != null && prestamoRepository.existsById(prestamo.getId())) {
            prestamoRepository.save(prestamo);
        } else {
            throw new RuntimeException("Prestamo not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public List<Prestamo> findByPrestamoId(Long prestamoId) {
        return prestamoRepository.findById(prestamoId).map(List::of).orElseThrow(() -> new RuntimeException("Prestamo not found"));
    }

    @Override
    public ClientByPrestamoResponse findClientsByPrestamoId(Long prestamoId) {
        // Consultar el préstamo
        Prestamo prestamo = prestamoRepository.findById(prestamoId).orElse(new Prestamo());
        // Obtener los clientes
        List<ClientDTO> clientDTOList = clientClient.findAllClientByPrestamo(prestamoId);

        return ClientByPrestamoResponse.builder()
                .numeroPrestamo(prestamo.getNumeroPrestamo())
                .monto(prestamo.getMonto())
                .tasaInteres(prestamo.getTasaInteres())
                .plazo(prestamo.getPlazo())
                .estado(prestamo.getEstado())
                .clientDTOList(clientDTOList)
                .build();
    }
}
