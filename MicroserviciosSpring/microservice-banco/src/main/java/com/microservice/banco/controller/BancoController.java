package com.microservice.banco.controller;

import com.microservice.banco.entities.Banco;
import com.microservice.banco.service.IBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/banco")
public class BancoController {

    @Autowired
    private IBancoService bancoService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBanco(@RequestBody Banco banco) {
        bancoService.save(banco);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllBanco() {
        return ResponseEntity.ok(bancoService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {return ResponseEntity.ok(bancoService.findById(id));}

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateBanco(@PathVariable Long id, @RequestBody Banco banco) {
        Banco existingBanco = bancoService.findById(id);
        if (existingBanco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Banco not found");
        }
        existingBanco.setName(banco.getName());
        existingBanco.setAddress(banco.getAddress());
        bancoService.save(existingBanco);
        return ResponseEntity.ok(existingBanco);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteBanco(@PathVariable Long id) {
        try {
            bancoService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Banco not found");
        }
    }

    @GetMapping("/search-client/{bancoId}")
    public ResponseEntity<?> findClientByIdBanco(@PathVariable Long bancoId) {
        return  ResponseEntity.ok(bancoService.findClientsByBancoId(bancoId));
    }
}
