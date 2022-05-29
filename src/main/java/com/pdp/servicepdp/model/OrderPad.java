package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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
    private RestaurantTable table;

    @OneToMany(mappedBy = "orderPad")
    private Set<Client> clients;

    public OrderPad() {
        this.setId(0);
        this.setOpenAt(LocalDateTime.now());
        this.setTable(null);
        this.setClients(new HashSet<>());
    }

    public OrderPad(int id, LocalDateTime openAt, LocalDateTime closedAt, RestaurantTable table, Set<Client> clients) {
        this.id = id;
        this.openAt = openAt;
        this.closedAt = closedAt;
        this.table = table;
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

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
