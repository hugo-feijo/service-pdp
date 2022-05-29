package com.pdp.servicepdp.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT_UNITY")
public class RestaurantUnity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_restaurant", nullable = false, referencedColumnName = "id")
    private Restaurant restaurant;

    public RestaurantUnity() {
        this.setId(0);
        this.setName("NO NAME");
        this.setRestaurant(null);
    }

    public RestaurantUnity(int id, String name, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
