package com.pdp.servicepdp.model.dto;

import java.util.Set;


public record SolicitationDTO (Integer orderPad, Set<Integer> clientsId, Set<Integer> itemsId) {

}
