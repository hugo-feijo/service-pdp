package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Client;
import com.pdp.servicepdp.model.dto.ClientDTO;
import com.pdp.servicepdp.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "${cors.url}")
@RequestMapping("/v1/api/client")
public class ClientRest {

    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO, @RequestHeader("X-Order-Pad-Id") Integer orderPadId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(clientDTO, orderPadId));
    }

    @PutMapping("/{clientId}/inactive")
    public Client inactiveClient(@PathVariable Integer clientId) {
        return clientService.inactiveById(clientId);
    }
}
