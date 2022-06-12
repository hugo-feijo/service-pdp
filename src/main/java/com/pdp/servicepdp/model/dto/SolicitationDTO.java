package com.pdp.servicepdp.model.dto;

import java.io.Serializable;
import java.util.Set;

public class SolicitationDTO implements Serializable {
    private Set<Integer> clientsId;
    private Set<Integer> itemsId;

    public SolicitationDTO() {
    }

    public SolicitationDTO(Set<Integer> clientsId, Set<Integer> itemsId) {
        this.clientsId = clientsId;
        this.itemsId = itemsId;
    }

    public Set<Integer> getClientsId() {
        return clientsId;
    }

    public void setClientsId(Set<Integer> clientsId) {
        this.clientsId = clientsId;
    }

    public Set<Integer> getItemsId() {
        return itemsId;
    }

    public void setItemsId(Set<Integer> itemsId) {
        this.itemsId = itemsId;
    }
}
