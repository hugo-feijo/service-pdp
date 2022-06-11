package com.pdp.servicepdp.model.dto;

import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.model.RestaurantTable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderPadDTO  implements java.io.Serializable{
    private int id;
    private LocalDateTime openAt;
    private RestaurantTable restaurantTable;
    private Set<ClientDTO> clients;

    public OrderPadDTO() {
    }

    public OrderPadDTO(OrderPad orderPad) {
        this.id = orderPad.getId();
        this.openAt = orderPad.getOpenAt();
        this.restaurantTable = orderPad.getRestaurantTable();
        this.clients = orderPad.getClients() != null ? orderPad.getClients().stream().map(ClientDTO::new).collect(Collectors.toSet()) : new HashSet<>();
    }

    public OrderPadDTO(int id, LocalDateTime openAt, RestaurantTable restaurantTable, Set<ClientDTO> clients) {
        this.id = id;
        this.openAt = openAt;
        this.restaurantTable = restaurantTable;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOpenAt() {
        return openAt;
    }

    public void setOpenAt(LocalDateTime openAt) {
        this.openAt = openAt;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Set<ClientDTO> getClients() {
        return clients;
    }

    public void setClients(Set<ClientDTO> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPadDTO that = (OrderPadDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
