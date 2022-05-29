package com.pdp.servicepdp.service;

import com.pdp.servicepdp.model.Client;
import com.pdp.servicepdp.model.dto.ClientDTO;
import com.pdp.servicepdp.repository.ClientDAO;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientDAO clientDAO;
    private final OrderPadService orderPadService;

    public ClientService(ClientDAO clientDAO, OrderPadService orderPadService) {
        this.clientDAO = clientDAO;
        this.orderPadService = orderPadService;
    }

    public Client create(ClientDTO clientDTO, Integer orderPadId) {
        var client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setOrderPad(orderPadService.findById(orderPadId));
        clientDAO.create(client);
        return client;
    }
}
