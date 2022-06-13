package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.ClientsSolicitation;
import com.pdp.servicepdp.model.ItemsSolicitation;
import com.pdp.servicepdp.model.Solicitation;
import com.pdp.servicepdp.model.dto.SolicitationDTO;
import com.pdp.servicepdp.repository.ClientsSolicitationDAO;
import com.pdp.servicepdp.repository.ItemsSolicitationDAO;
import com.pdp.servicepdp.repository.SolicitationDAO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitationService {
    private final SolicitationDAO solicitationDAO;
    private final ClientsSolicitationDAO clientsSolicitationDAO;
    private final ItemsSolicitationDAO itemsSolicitationDAO;
    private final ClientService clientService;
    private final ItemService itemService;

    public SolicitationService(SolicitationDAO solicitationDAO, ClientsSolicitationDAO clientsSolicitationDAO, ItemsSolicitationDAO itemsSolicitationDAO, ClientService clientService, ItemService itemService) {
        this.solicitationDAO = solicitationDAO;
        this.clientsSolicitationDAO = clientsSolicitationDAO;
        this.itemsSolicitationDAO = itemsSolicitationDAO;
        this.clientService = clientService;
        this.itemService = itemService;
    }

    public String create(SolicitationDTO solicitationDTO) {
        var solicitation = new Solicitation();
        solicitationDAO.save(solicitation);
        var clients = solicitationDTO.getClientsId().stream().map(clientService::findById).collect(Collectors.toSet());
        var items = solicitationDTO.getItemsId().stream().map(itemService::findById).collect(Collectors.toSet());
        var clientsSolicitation = new HashSet<ClientsSolicitation>();
        var itemsSolicitation = new HashSet<ItemsSolicitation>();
        items.forEach(item -> {
            var itemSolicitation = new ItemsSolicitation(0, item, solicitation);
            itemsSolicitationDAO.save(itemSolicitation);
            itemsSolicitation.add(itemSolicitation);
        });
        clients.forEach(client -> {
            var clientSolicitation = new ClientsSolicitation(0, client, solicitation);
            clientsSolicitationDAO.save(clientSolicitation);
            clientsSolicitation.add(clientSolicitation);
        });

        solicitation.setItems(itemsSolicitation);
        solicitation.setClientsSolicitation(clientsSolicitation);
        return "Solicitation created with success";
    }

    public List<Solicitation> getSolicitationsByClientId(Integer clientId) {
        return solicitationDAO.findByClientId(clientId);
    }
}
