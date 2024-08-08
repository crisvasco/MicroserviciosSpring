package com.microservice.dinero.controller;

import com.microservice.dinero.entities.Dinero;
import com.microservice.dinero.service.IDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dinero")
public class DineroController {

    @Autowired
    private IDineroService dineroService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDinero(@RequestBody Dinero dinero) {
        dineroService.save(dinero);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllDinero() {
        return ResponseEntity.ok(dineroService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(dineroService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateDinero(@PathVariable Long id, @RequestBody Dinero dinero) {
        Dinero existingDinero = dineroService.findById(id);
        if (existingDinero == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dinero not found");
        }
        existingDinero.setCantidad(dinero.getCantidad());
        existingDinero.setTipoMoneda(dinero.getTipoMoneda());
        dineroService.save(existingDinero);
        return ResponseEntity.ok(existingDinero);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteDinero(@PathVariable Long id) {
        try {
            dineroService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dinero not found");
        }
    }

    @GetMapping("/search-client/{dineroId}")
    public ResponseEntity<?> findClientByIdDinero(@PathVariable Long dineroId) {
        return ResponseEntity.ok(dineroService.findClientsByDineroId(dineroId));
    }
}
