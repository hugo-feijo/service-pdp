package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.ClientsSolicitation;
import com.pdp.servicepdp.model.ItemsSolicitation;
import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationDTO;
import com.pdp.servicepdp.repository.ClientsSolicitationRepository;
import com.pdp.servicepdp.repository.ItemsSolicitationRepositoy;
import com.pdp.servicepdp.repository.SolicitationRepository;
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

    public SolicitationService(SolicitationRepository solicitationRepository, ClientsSolicitationRepository clientsSolicitationRepository, ItemsSolicitationRepositoy itemsSolicitationRepositoy, ClientService clientService, ItemService itemService) {
        this.solicitationRepository = solicitationRepository;
        this.clientsSolicitationRepository = clientsSolicitationRepository;
        this.itemsSolicitationRepositoy = itemsSolicitationRepositoy;
        this.clientService = clientService;
        this.itemService = itemService;
    }

    public String create(SolicitationDTO solicitationDTO) {
        var solicitation = new Solicitation();
        solicitationRepository.save(solicitation);
        var clients = solicitationDTO.getClientsId().stream().map(clientService::findById).collect(Collectors.toSet());
        var items = solicitationDTO.getItemsId().stream().map(itemService::findById).collect(Collectors.toSet());
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
        return "Solicitation created with success";
    }

    public List<Solicitation> getSolicitationsByClientId(Integer clientId) {
        return solicitationRepository.findByClientId(clientId);
    }
}
