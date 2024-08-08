package com.microservice.tarjeta.controller;

import com.microservice.tarjeta.entities.Tarjeta;
import com.microservice.tarjeta.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tarjeta")
public class TarjetaController {

    @Autowired
    private ITarjetaService tarjetaService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTarjeta(@RequestBody Tarjeta tarjeta) {
        tarjetaService.save(tarjeta);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllTarjeta() {
        return ResponseEntity.ok(tarjetaService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tarjetaService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateTarjeta(@PathVariable Long id, @RequestBody Tarjeta tarjeta) {
        Tarjeta existingTarjeta = tarjetaService.findById(id);
        if (existingTarjeta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarjeta not found");
        }
        existingTarjeta.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        existingTarjeta.setNombreTitular(tarjeta.getNombreTitular());
        existingTarjeta.setFechaExpiracion(tarjeta.getFechaExpiracion());
        tarjetaService.save(existingTarjeta);
        return ResponseEntity.ok(existingTarjeta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteTarjeta(@PathVariable Long id) {
        try {
            tarjetaService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarjeta not found");
        }
    }

    @GetMapping("/search-client/{tarjetaId}")
    public ResponseEntity<?> findClientByIdTarjeta(@PathVariable Long tarjetaId) {
        return ResponseEntity.ok(tarjetaService.findClientsByTarjetaId(tarjetaId));
    }
}
