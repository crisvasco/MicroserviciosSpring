package com.microservice.prestamo.persistence;


import com.microservice.prestamo.entities.Prestamo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {

    List<Prestamo> findAllById(Long Id);

}
