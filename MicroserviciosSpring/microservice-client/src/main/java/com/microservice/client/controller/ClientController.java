package com.microservice.client.controller;


import com.microservice.client.entities.Client;
import com.microservice.client.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client) {
        clientService.save(client);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllClient(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){ return ResponseEntity.ok(clientService.findById(id));}

    @GetMapping("/search_by_banco/{bancoId}")
    public ResponseEntity<?> findClientByIdBanco(@PathVariable Long bancoId){
        return ResponseEntity.ok(clientService.findByIdBanco(bancoId));
    }

    @GetMapping("/search_by_cuenta/{cuentaId}")
    public ResponseEntity<?> findClientByIdCuenta(@PathVariable Long cuentaId){
        return ResponseEntity.ok(clientService.findByIdCuenta(cuentaId));
    }

    @GetMapping("/search_by_tarjeta/{tarjetaId}")
    public ResponseEntity<?> findClientByIdTarjeta(@PathVariable Long tarjetaId){
        return ResponseEntity.ok(clientService.findByIdTarjeta(tarjetaId));
    }

    @GetMapping("/search_by_prestamo/{prestamoId}")
    public ResponseEntity<?> findClientByIdPrestamo(@PathVariable Long prestamoId){
        return ResponseEntity.ok(clientService.findByIdPrestamo(prestamoId));
    }

    @GetMapping("/search_by_notificacion/{notificacionId}")
    public ResponseEntity<?> findClientByIdNotificacion(@PathVariable Long notificacionId) {
        return ResponseEntity.ok(clientService.findByIdNotificacion(notificacionId));
    }

    @GetMapping("/search_by_dinero/{dineroId}")
    public ResponseEntity<?> findClientByIdDinero(@PathVariable Long dineroId) {
        return ResponseEntity.ok(clientService.findByIdDinero(dineroId));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client existingClient = clientService.findById(id);
        if (existingClient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        // Actualiza otros campos según sea necesario
        clientService.save(existingClient);
        return ResponseEntity.ok(existingClient);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Client existingClient = clientService.findById(id);
        if (existingClient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
