package com.pdp.servicepdp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/client")
public class ClientRest {

    @PostMapping
    public String createClient() {
        return "Client created";
    }
}
