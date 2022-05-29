package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MENU")
public class Menu implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @OneToMany
    private Set<Item> items;

    @OneToOne
    private RestaurantUnity restaurantUnity;

    public Menu() {
        this.setId(0);
        this.setItems(new HashSet<>());
        this.setRestaurantUnity(null);
    }

    public Menu(int id, Set<Item> items, RestaurantUnity restaurantUnity) {
        this.id = id;
        this.items = items;
        this.restaurantUnity = restaurantUnity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public RestaurantUnity getRestaurantUnity() {
        return restaurantUnity;
    }

    public void setRestaurantUnity(RestaurantUnity restaurantUnity) {
        this.restaurantUnity = restaurantUnity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
