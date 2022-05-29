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
}
