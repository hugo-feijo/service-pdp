package com.pdp.servicepdp.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "image_banner_url", length = 10485760, nullable = false)
    private String imageBannerUrl;

    public Restaurant() {
        this.setId(0);
        this.setName("NO NAME");
        this.setImageBannerUrl(null);
    }

    public Restaurant(int id, String name, String imageBannerUrl) {
        this.id = id;
        this.name = name;
        this.imageBannerUrl = imageBannerUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageBannerUrl() {
        return imageBannerUrl;
    }

    public void setImageBannerUrl(String imageBannerUrl) {
        this.imageBannerUrl = imageBannerUrl;
    }
}
