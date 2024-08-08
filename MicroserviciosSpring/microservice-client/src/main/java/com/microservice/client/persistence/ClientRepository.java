package com.microservice.client.persistence;

import com.microservice.client.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

//    @Query("SELECT s FROM Client s WHERE s.bancoId= :idBanco")
//    List<Client> findAllClient(Long idBanco);

    List<Client> findAllByBancoId(Long idBanco);
    List<Client> findAllByCuentaId(Long idCuenta);
    List<Client> findAllByTarjetaId(Long idTarjeta);
    List<Client> findAllByPrestamoId(Long idPrestamo);
    List<Client> findAllByNotificacionId(Long idNotificacion);
    List<Client> findAllByDineroId(Long idDinero);
}
