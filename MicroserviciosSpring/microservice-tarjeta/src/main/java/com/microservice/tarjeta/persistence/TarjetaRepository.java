package com.microservice.tarjeta.persistence;

import com.microservice.tarjeta.entities.Tarjeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long> {

    List<Tarjeta> findAllById(Long Id);

}
