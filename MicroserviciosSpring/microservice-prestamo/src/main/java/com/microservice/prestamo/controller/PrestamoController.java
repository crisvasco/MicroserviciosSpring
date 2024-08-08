package com.microservice.prestamo.controller;

import com.microservice.prestamo.entities.Prestamo;
import com.microservice.prestamo.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prestamo")
public class PrestamoController {

    @Autowired
    private IPrestamoService prestamoService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePrestamo(@RequestBody Prestamo prestamo) {
        prestamoService.save(prestamo);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPrestamo() {
        return ResponseEntity.ok(prestamoService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        Prestamo existingPrestamo = prestamoService.findById(id);
        if (existingPrestamo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo not found");
        }
        existingPrestamo.setNumeroPrestamo(prestamo.getNumeroPrestamo());
        existingPrestamo.setMonto(prestamo.getMonto());
        existingPrestamo.setTasaInteres(prestamo.getTasaInteres());
        existingPrestamo.setPlazo(prestamo.getPlazo());
        existingPrestamo.setEstado(prestamo.getEstado());
        existingPrestamo.setNombreBanco(prestamo.getNombreBanco());
        prestamoService.save(existingPrestamo);
        return ResponseEntity.ok(existingPrestamo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deletePrestamo(@PathVariable Long id) {
        try {
            prestamoService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo not found");
        }
    }

    @GetMapping("/search-client/{prestamoId}")
    public ResponseEntity<?> findClientByIdPrestamo(@PathVariable Long prestamoId) {
        return ResponseEntity.ok(prestamoService.findClientsByPrestamoId(prestamoId));
    }
}
