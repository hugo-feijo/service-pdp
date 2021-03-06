package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "solicitation")
    private Set<ItemsSolicitation> items;

    @OneToMany(mappedBy = "solicitation")
    private Set<ClientsSolicitation> clientsSolicitation;

    public Solicitation() {
        this.setId(0);
        this.setSolicitedAt(LocalDateTime.now());
        this.setItems(new HashSet<>());
        this.setClientsSolicitation(new HashSet<>());
    }

    public Solicitation(int id, LocalDateTime solicitedAt, LocalDateTime deliveredAt, Set<ItemsSolicitation> items,
                        Set<ClientsSolicitation> clientsSolicitation) {
        this.id = id;
        this.solicitedAt = solicitedAt;
        this.deliveredAt = deliveredAt;
        this.items = items;
        this.clientsSolicitation = clientsSolicitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getSolicitedAt() {
        return solicitedAt;
    }

    public void setSolicitedAt(LocalDateTime solicitedAt) {
        this.solicitedAt = solicitedAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Set<ItemsSolicitation> getItems() {
        return items;
    }

    public void setItems(Set<ItemsSolicitation> items) {
        this.items = items;
    }

    public Set<ClientsSolicitation> getClientsSolicitation() {
        return clientsSolicitation;
    }

    public void setClientsSolicitation(Set<ClientsSolicitation> clientsSolicitation) {
        this.clientsSolicitation = clientsSolicitation;
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
