package com.pdp.servicepdp.model.dto;

import com.pdp.servicepdp.model.OrderPad;
import com.pdp.servicepdp.model.RestaurantTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTableDTO {
    private Integer id;
    private String identification;
    private String name;
    private List<OrderPadDTO> orderPadOpened;

    public RestaurantTableDTO(RestaurantTable restaurantTable, List<OrderPad> orderPads) {
        this.setId(restaurantTable.getId());
        this.setName(restaurantTable.getName());
        this.setIdentification(restaurantTable.getIdentification());
        this.setOrderPadOpened(orderPads.stream().map(OrderPadDTO::new).toList());
    }
}
