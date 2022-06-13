package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RESTAURANT_TABLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "id_restaurant_unity"})
})
public class RestaurantTable implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String identification;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_restaurant_unity", nullable = false, referencedColumnName = "id")
    private RestaurantUnity restaurantUnity;

    public RestaurantTable() {
        this.setId(0);
        this.setIdentification("NO IDENTIFICATION");
        this.setRestaurantUnity(null);
    }

    public RestaurantTable(int id, String identification, RestaurantUnity restaurantUnity) {
        this.id = id;
        this.identification = identification;
        this.restaurantUnity = restaurantUnity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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
        RestaurantTable that = (RestaurantTable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
