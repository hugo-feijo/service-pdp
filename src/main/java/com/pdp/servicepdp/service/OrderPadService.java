package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Client;
import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.model.dto.ClientDTO;
import com.pdp.servicepdp.model.dto.OrderPadDTO;
import com.pdp.servicepdp.repository.OrderPadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderPadService {

    private final OrderPadRepository orderPadRepository;
    private final RestaurantTableService restaurantTableService;

    private final SimpMessagingTemplate simpMessagingTemplate;


    public OrderPadService(OrderPadRepository orderPadRepository, RestaurantTableService restaurantTableService, SimpMessagingTemplate simpMessagingTemplate) {
        this.orderPadRepository = orderPadRepository;
        this.restaurantTableService = restaurantTableService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public OrderPadDTO getOpenedOrderPadOrCreate(Integer tableId, String tableCode) {
        List<OrderPad> openedOrderPad = orderPadRepository.getOpenedOrderPadByTableIdOrTableCode(tableId, tableCode);
        var orderPadDTO = switch (openedOrderPad.size()) {
            case 0 -> new OrderPadDTO(this.createOrderPad(tableId));
            case 1 -> new OrderPadDTO(openedOrderPad.get(0));
            default -> throw new GlobalException("More than one opened order pad", HttpStatus.BAD_REQUEST);
        };
        updateOrderPadClient(orderPadDTO.getClients(), orderPadDTO.getId());
        return orderPadDTO;
    }

    public OrderPad createOrderPad(Integer tableId) {
        var orderPad = new OrderPad();
        orderPad.setRestaurantTable(restaurantTableService.findById(tableId));
        orderPadRepository.save(orderPad);
        return orderPad;
    }

    public OrderPad findById(Integer orderPadId) {
        var orderPad = orderPadRepository.findById(orderPadId);
        if (orderPad.isEmpty())
            throw new GlobalException("OrderPad not found", HttpStatus.NOT_FOUND);
        return orderPad.get();
    }

    public void closeOrderPadIfNoClient(Integer orderPadId) {
        var orderPad = findById(orderPadId);
        var clientsActive = orderPad.getClients().stream().filter(Client::getActive).collect(Collectors.toSet());
        if(clientsActive.isEmpty()) {
            orderPad.setClosedAt(LocalDateTime.now());
            orderPadRepository.save(orderPad);
        }
    }

    public Set<ClientDTO> updateOrderPadClient(Integer orderPadId) {
        var clients = findById(orderPadId).getClients().stream().filter(Client::getActive).map(ClientDTO::new).collect(Collectors.toSet());
        return updateOrderPadClient(clients, orderPadId);
    }

    public Set<ClientDTO> updateOrderPadClient(Set<ClientDTO> clients, Integer orderPadId) {
        simpMessagingTemplate.convertAndSendToUser(orderPadId.toString(), "/order-pad/update", clients);// /client/1/order-pad/update
        return clients;
    }
}
