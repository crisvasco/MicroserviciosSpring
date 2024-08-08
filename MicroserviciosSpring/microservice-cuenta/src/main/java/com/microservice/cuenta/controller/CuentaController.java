package com.microservice.cuenta.controller;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCuenta(@RequestBody Cuenta cuenta) {
        cuentaService.save(cuenta);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCuenta() {
        return ResponseEntity.ok(cuentaService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Cuenta existingCuenta = cuentaService.findById(id);
        if (existingCuenta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta not found");
        }
        existingCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        existingCuenta.setTipoCuenta(cuenta.getTipoCuenta());
        existingCuenta.setSaldo(cuenta.getSaldo());
        cuentaService.save(existingCuenta);
        return ResponseEntity.ok(existingCuenta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable Long id) {
        try {
            cuentaService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta not found");
        }
    }

    @GetMapping("/search-client/{cuentaId}")
    public ResponseEntity<?> findClientByIdCuenta(@PathVariable Long cuentaId) {
        return ResponseEntity.ok(cuentaService.findClientsByCuentaId(cuentaId));
    }
}
