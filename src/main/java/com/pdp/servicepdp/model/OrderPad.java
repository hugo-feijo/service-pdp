package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
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
}
