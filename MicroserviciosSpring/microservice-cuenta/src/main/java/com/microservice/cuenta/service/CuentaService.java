package com.microservice.cuenta.service;

import com.microservice.cuenta.client.ClientClient;
import com.microservice.cuenta.dto.ClientDTO;
import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.http.response.ClientByCuentaResponse;
import com.microservice.cuenta.persistence.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService implements ICuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta not found"));
    }

    @Override
    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public void update(Cuenta cuenta) {
        if (cuenta.getId() != null && cuentaRepository.existsById(cuenta.getId())) {
            cuentaRepository.save(cuenta);
        } else {
            throw new RuntimeException("Cuenta not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public List<Cuenta> findByCuentaId(Long cuentaId) {
        return cuentaRepository.findById(cuentaId).map(List::of).orElseThrow(() -> new RuntimeException("Cuenta not found"));
    }

    @Override
    public ClientByCuentaResponse findClientsByCuentaId(Long cuentaId) {
        // Consultar la cuenta
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElse(new Cuenta());
        // Obtener los clientes
        List<ClientDTO> clientDTOList = clientClient.findAllClientByCuenta(cuentaId);

        return ClientByCuentaResponse.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldo(cuenta.getSaldo())
                .clientDTOList(clientDTOList)
                .build();
    }
}
