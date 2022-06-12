package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationDTO;
import com.pdp.servicepdp.service.SolicitationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/solicitation")
public class SolicitationRest {

    private final SolicitationService solicitationService;

    public SolicitationRest(SolicitationService solicitationService) {
        this.solicitationService = solicitationService;
    }

    @PostMapping
    public ResponseEntity<Solicitation> createClient(@RequestBody SolicitationDTO solicitationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitationService.create(solicitationDTO));
    }
}
