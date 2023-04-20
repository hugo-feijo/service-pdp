package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.ClientsSolicitation;
import com.pdp.servicepdp.model.ItemsSolicitation;
import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationDTO;
import com.pdp.servicepdp.repository.ClientsSolicitationRepository;
import com.pdp.servicepdp.repository.ItemsSolicitationRepositoy;
import com.pdp.servicepdp.repository.SolicitationRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitationService {
    private final SolicitationRepository solicitationRepository;
    private final ClientsSolicitationRepository clientsSolicitationRepository;
    private final ItemsSolicitationRepositoy itemsSolicitationRepositoy;
    private final ClientService clientService;
    private final ItemService itemService;
    private final OrderPadService orderPadService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public SolicitationService(SolicitationRepository solicitationRepository, ClientsSolicitationRepository clientsSolicitationRepository,
                               ItemsSolicitationRepositoy itemsSolicitationRepositoy, ClientService clientService, ItemService itemService,
                               OrderPadService orderPadService, SimpMessagingTemplate simpMessagingTemplate) {
        this.solicitationRepository = solicitationRepository;
        this.clientsSolicitationRepository = clientsSolicitationRepository;
        this.itemsSolicitationRepositoy = itemsSolicitationRepositoy;
        this.clientService = clientService;
        this.itemService = itemService;
        this.orderPadService = orderPadService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public String create(SolicitationDTO solicitationDTO) {
        var solicitation = new Solicitation();
        solicitation.setOrderPad(orderPadService.findById(solicitationDTO.orderPad()));
        solicitationRepository.save(solicitation);
        var clients = solicitationDTO.clientsId().stream().map(clientService::findById).collect(Collectors.toSet());
        var items = solicitationDTO.itemsId().stream().map(itemService::findById).collect(Collectors.toSet());
        var clientsSolicitation = new HashSet<ClientsSolicitation>();
        var itemsSolicitation = new HashSet<ItemsSolicitation>();
        items.forEach(item -> {
            var itemSolicitation = new ItemsSolicitation(0, item, solicitation);
            itemsSolicitationRepositoy.save(itemSolicitation);
            itemsSolicitation.add(itemSolicitation);
        });
        clients.forEach(client -> {
            var clientSolicitation = new ClientsSolicitation(0, client, solicitation);
            clientsSolicitationRepository.save(clientSolicitation);
            clientsSolicitation.add(clientSolicitation);
        });

        solicitation.setItems(itemsSolicitation);
        solicitation.setClientsSolicitation(clientsSolicitation);
        getSolicitations(solicitation.getOrderPad().getRestaurantTable().getRestaurantUnity().getId());
        return "Solicitation created with success";
    }

    public List<Solicitation> getSolicitationsByClientId(Integer clientId) {
        return solicitationRepository.findByClientId(clientId);
    }

    public List<Solicitation> getSolicitations(Integer restaurantUnity) {
        var solicitations = solicitationRepository.findByOrderPadRestaurantTableRestaurantUnityId(restaurantUnity);
        simpMessagingTemplate.convertAndSendToUser(restaurantUnity.toString(), "/solicitation/update", solicitations);// /client/1/solicitation/update
        return solicitations;
    }

}
