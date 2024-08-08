package com.microservice.banco.service;

import com.microservice.banco.client.ClientClient;
import com.microservice.banco.dto.ClientDTO;
import com.microservice.banco.entities.Banco;
import com.microservice.banco.http.response.ClientByBancoResponse;
import com.microservice.banco.persistence.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService implements IBancoService {

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<Banco> findAll() {
        return (List<Banco>) bancoRepository.findAll();
    }

    @Override
    public Banco findById(Long id) {
        return bancoRepository.findById(id).orElseThrow(() -> new RuntimeException("Banco not found"));
    }

    @Override
    public void save(Banco banco) {
        bancoRepository.save(banco);
    }

    @Override
    public void update(Banco banco) {
        if (banco.getId() != null && bancoRepository.existsById(banco.getId())) {
            bancoRepository.save(banco);
        } else {
            throw new RuntimeException("Banco not found or id is null");
        }
    }

    @Override
    public void delete(Long id) {
        bancoRepository.deleteById(id);
    }

    @Override
    public List<Banco> findByBancoId(Long bancoId) {
        // Suponiendo que este método debería encontrar todos los bancos con el ID dado,
        // pero si no tiene sentido, necesitas definir el método apropiado en el repositorio.
        return bancoRepository.findById(bancoId).map(List::of).orElseThrow(() -> new RuntimeException("Banco not found"));
    }

    @Override
    public ClientByBancoResponse findClientsByBancoId(Long bancoId) {
        //consultar el banco
        Banco banco = bancoRepository.findById(bancoId).orElse(new Banco());
        //obtener los clientes
        List<ClientDTO > clientDTOList = clientClient.findAllClientByBanco(bancoId);

        return ClientByBancoResponse.builder()
                .bancoName(banco.getName())
                .address(banco.getAddress())
                .clientDTOList(clientDTOList)
                .build();
    }
}
