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
}
