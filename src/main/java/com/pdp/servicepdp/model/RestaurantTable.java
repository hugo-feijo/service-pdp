package com.pdp.servicepdp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "RESTAURANT_TABLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "id_restaurant_unity"})
})
public class RestaurantTable implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "identification", length = 7, nullable = false, unique = true)
    private String identification;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_restaurant_unity", nullable = false, referencedColumnName = "id")
    private RestaurantUnity restaurantUnity;

    public RestaurantTable() {
        this.setId(0);
        this.setIdentification(UUID.randomUUID().toString().replace("-", "").substring(0, 5));
        this.setName("NO NAME");
        this.setRestaurantUnity(null);
    }

    public RestaurantTable(int id, String identification, String name, RestaurantUnity restaurantUnity) {
        this.id = id;
        this.identification = identification;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
