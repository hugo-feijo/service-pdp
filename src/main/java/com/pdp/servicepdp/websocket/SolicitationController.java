package com.pdp.servicepdp.websocket;

import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationRequest;
import com.pdp.servicepdp.service.SolicitationService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SolicitationController {
    private final SolicitationService solicitationService;

    public SolicitationController(SolicitationService solicitationService) {
        this.solicitationService = solicitationService;
    }

    @MessageMapping("/solicitation")
    public List<Solicitation> getSolicitation(@Payload SolicitationRequest solicitationRequest){
        return solicitationService.getSolicitations(solicitationRequest.restaurantUnityId());
    }
}
