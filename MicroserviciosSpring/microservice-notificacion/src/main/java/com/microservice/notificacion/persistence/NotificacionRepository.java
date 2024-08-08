package com.microservice.notificacion.persistence;


import com.microservice.notificacion.entities.Notificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {

    List<Notificacion> findAllById(Long Id);

}
