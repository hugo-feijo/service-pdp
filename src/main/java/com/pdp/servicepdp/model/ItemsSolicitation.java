package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ITEMS_SOLICITATION")
public class ItemsSolicitation implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitation", nullable = false)
    private Solicitation solicitation;

    public ItemsSolicitation() {
    }

    public ItemsSolicitation(int id, Item item, Solicitation solicitation) {
        this.id = id;
        this.item = item;
        this.solicitation = solicitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsSolicitation itemsSolicitation = (ItemsSolicitation) o;
        return id == itemsSolicitation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
