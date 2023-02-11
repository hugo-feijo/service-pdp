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
        checkRequiredParameters(clientDTO);
        var client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setOrderPad(orderPadService.findById(orderPadId));
        clientRepository.save(client);
        orderPadService.updateOrderPadClient(orderPadId);
        return client;
    }

    private void checkRequiredParameters(ClientDTO clientDTO) {
        if(clientDTO.getName() == null || clientDTO.getCpf() == null ||
                clientDTO.getName().isBlank() || clientDTO.getCpf().isBlank())
            throw new GlobalException("Client name and CPF is required.", HttpStatus.BAD_REQUEST);
    }

    public Client findById(Integer id) {
        var client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new GlobalException("Client not found", HttpStatus.NOT_FOUND);
        return client.get();
    }

    public Client inactiveById(Integer clientId, Integer orderPadId) {
        var client = this.findById(clientId);
        client.setActive(false);
        clientRepository.save(client);
        orderPadService.updateOrderPadClient(orderPadId);
        return client;
    }
}
