package com.pdp.servicepdp.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", length = 250, nullable = false, unique = true)
    private String identification;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_restaurant_unity", nullable = false, referencedColumnName = "id")
    private RestaurantUnity restaurantUnity;

    public RestaurantTable() {
    }

    public RestaurantTable(int id, String identification, RestaurantUnity restaurantUnity) {
        this.id = id;
        this.identification = identification;
        this.restaurantUnity = restaurantUnity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public RestaurantUnity getRestaurantUnity() {
        return restaurantUnity;
    }

    public void setRestaurantUnity(RestaurantUnity restaurantUnity) {
        this.restaurantUnity = restaurantUnity;
    }
}
