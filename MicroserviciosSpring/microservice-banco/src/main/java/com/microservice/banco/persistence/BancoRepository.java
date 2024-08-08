package com.microservice.banco.persistence;


import com.microservice.banco.entities.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepository extends CrudRepository<Banco, Long> {

    List<Banco> findAllById(Long Id);

}
