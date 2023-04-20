package com.pdp.servicepdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "SOLICITATION")
public class Solicitation implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "solicited_at",nullable = false)
    private LocalDateTime solicitedAt;

    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;

    @ManyToOne
    @JoinColumn(name = "id_order_pad",nullable = false)
    private OrderPad orderPad;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "solicitation")
    private Set<ItemsSolicitation> items;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "solicitation")
    private Set<ClientsSolicitation> clientsSolicitation;

    public Solicitation() {
        this.setId(0);
        this.setSolicitedAt(LocalDateTime.now());
        this.setItems(new HashSet<>());
        this.setClientsSolicitation(new HashSet<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitation that = (Solicitation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
