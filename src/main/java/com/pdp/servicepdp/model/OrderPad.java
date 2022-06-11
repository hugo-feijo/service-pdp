package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ORDER_PAD")
public class OrderPad implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "open_at",nullable = false)
    private LocalDateTime openAt;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_restaurant_table", nullable = false, referencedColumnName = "id")
    private RestaurantTable restaurantTable;

    @OneToMany(mappedBy = "orderPad", fetch = FetchType.EAGER)
    private Set<Client> clients;

    public OrderPad() {
        this.setId(0);
        this.setOpenAt(LocalDateTime.now());
        this.setRestaurantTable(null);
        this.setClients(new HashSet<>());
    }

    public OrderPad(int id, LocalDateTime openAt, LocalDateTime closedAt, RestaurantTable restaurantTable, Set<Client> clients) {
        this.id = id;
        this.openAt = openAt;
        this.closedAt = closedAt;
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

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPad orderPad = (OrderPad) o;
        return id == orderPad.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
