package com.sda.shop.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users_app")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @OneToOne
    @JoinColumn(name= "userTypeId")
    private UserTypeEntity userTypeEntity;

    private String username;
    private String password;
    private Date dateOfBirth;
    private String address;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    private Boolean enabled;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserTypeEntity getUserTypeEntity() {
        return userTypeEntity;
    }

    public void setUserTypeEntity(UserTypeEntity userTypeEntity) {
        this.userTypeEntity = userTypeEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
