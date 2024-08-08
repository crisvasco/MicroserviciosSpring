package com.microservice.notificacion.controller;

import com.microservice.notificacion.entities.Notificacion;
import com.microservice.notificacion.service.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notificacion")
public class NotificacionController {

    @Autowired
    private INotificacionService notificacionService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNotificacion(@RequestBody Notificacion notificacion) {
        notificacionService.save(notificacion);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllNotificacion() {
        return ResponseEntity.ok(notificacionService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.findById(id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        Notificacion existingNotificacion = notificacionService.findById(id);
        if (existingNotificacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notificación not found");
        }
        existingNotificacion.setTipoNotificacion(notificacion.getTipoNotificacion());
        existingNotificacion.setMensaje(notificacion.getMensaje());
        existingNotificacion.setFecha(notificacion.getFecha());
        notificacionService.save(existingNotificacion);
        return ResponseEntity.ok(existingNotificacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteNotificacion(@PathVariable Long id) {
        try {
            notificacionService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notificación not found");
        }
    }

    @GetMapping("/search-client/{notificacionId}")
    public ResponseEntity<?> findClientByIdNotificacion(@PathVariable Long notificacionId) {
        return ResponseEntity.ok(notificacionService.findClientsByNotificacionId(notificacionId));
    }
}
