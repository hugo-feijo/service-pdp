package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS_SOLICITATION")
public class ItemPictures implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_picture")
    private Picture picture;

    public ItemPictures() {
    }

    public ItemPictures(int id, Item item, Picture picture) {
        this.id = id;
        this.item = item;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getClient() {
        return item;
    }

    public void setClient(Item client) {
        this.item = client;
    }

    public Picture getSolicitation() {
        return picture;
    }

    public void setSolicitation(Picture solicitation) {
        this.picture = solicitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPictures itemPictures = (ItemPictures) o;
        return id == itemPictures.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
