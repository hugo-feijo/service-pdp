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

    @Column(name = "value", length = 250, nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private Set<ItemPictures> pictures;

    @JoinColumn(name = "active", nullable = false)
    private Boolean active;

    public Item(ItemDTO itemDTO, Category category) {
        this.setId(0);
        this.setTitle(itemDTO.getTitle());
        this.setDescription(itemDTO.getDescription());
        this.setCategory(category);
        this.setValue(itemDTO.getValue());
        this.setPictures(new HashSet<>());
        this.setActive(true);
    }

    public Item() {
        this.setId(0);
        this.setTitle("NO TITLE");
        this.setValue(0.0);
        this.setDescription("NO DESCRIPTION");
        this.setCategory(null);
        this.setPictures(new HashSet<>());
        this.setActive(true);
    }

    public Item(int id, String title, Double value, String description, Category category, Boolean active) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.description = description;
        this.category = category;
        this.active = active;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
