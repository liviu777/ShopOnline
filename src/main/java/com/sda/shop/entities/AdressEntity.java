package com.sda.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "address")
@Entity
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String country;
    private String city;
    private String street;
    @JsonProperty(value = "postalCode")
    private Integer postalcode;
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private HouseEntity house;

    public HouseEntity getHouse() {
        return house;
    }

    public void setHouse(HouseEntity house) {
        this.house = house;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer id) {
        this.addressId = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }
}
