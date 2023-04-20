package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationDTO;
import com.pdp.servicepdp.service.SolicitationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/solicitation")
public class SolicitationRest {

    private final SolicitationService solicitationService;

    public SolicitationRest(SolicitationService solicitationService) {
        this.solicitationService = solicitationService;
    }

    @PostMapping
    public ResponseEntity<String> createSolicitation(@RequestBody SolicitationDTO solicitationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitationService.create(solicitationDTO));
    }

    @GetMapping("/client/{clientId}")
    public List<Solicitation> getSolicitationsByClientId(@PathVariable Integer clientId) {
        return solicitationService.getSolicitationsByClientId(clientId);
    }

    @PutMapping("/{solicitationId}")
    public ResponseEntity<?> finishSolicitation(@PathVariable Integer solicitationId) {
        solicitationService.finishSolicitation(solicitationId);
        return ResponseEntity.ok().build();
    }
}
