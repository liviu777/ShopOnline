package com.sda.shop.entities;

import javax.persistence.*;

@Table(name = "houses")
@Entity
public class HouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
@OneToOne(mappedBy = "house")
    private AdressEntity address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AdressEntity getAddress() {
        return address;
    }

    public void setAddress(AdressEntity address) {
        this.address = address;
    }
}
