package com.microservice.dinero.persistence;

import com.microservice.dinero.entities.Dinero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DineroRepository extends CrudRepository<Dinero, Long> {

    List<Dinero> findAllById(Long Id);

}
