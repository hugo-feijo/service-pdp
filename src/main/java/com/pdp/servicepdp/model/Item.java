package com.pdp.servicepdp.model;

import com.pdp.servicepdp.model.dto.ItemDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ITEM")
public class Item implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "title", length = 250, nullable = false)
    private String title;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<ItemPictures> pictures;

    public Item(ItemDTO itemDTO, Category category) {
        this.setId(0);
        this.setTitle(itemDTO.getTitle());
        this.setDescription(itemDTO.getDescription());
        this.setCategory(category);
        this.setPictures(new HashSet<>());
    }

    public Item() {
        this.setId(0);
        this.setTitle("NO TITLE");
        this.setDescription("NO DESCRIPTION");
        this.setCategory(null);
        this.setPictures(new HashSet<>());
    }

    public Item(int id, String title, String description, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ItemPictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<ItemPictures> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
