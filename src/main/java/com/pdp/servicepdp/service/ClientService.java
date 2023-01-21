package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Client;
import com.pdp.servicepdp.model.dto.ClientDTO;
import com.pdp.servicepdp.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final OrderPadService orderPadService;

    public ClientService(ClientRepository clientRepository, OrderPadService orderPadService) {
        this.clientRepository = clientRepository;
        this.orderPadService = orderPadService;
    }

    public Client create(ClientDTO clientDTO, Integer orderPadId) {
        var client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setOrderPad(orderPadService.findById(orderPadId));
        clientRepository.save(client);
        return client;
    }

    public Client findById(Integer id) {
        var client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new GlobalException("Client not found", HttpStatus.NOT_FOUND);
        return client.get();
    }

    public Client inactiveById(Integer clientId) {
        var client = this.findById(clientId);
        client.setActive(false);
        clientRepository.save(client);
        return client;
    }
}
