package com.sda.shop.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column (length = 50)
    @Size(min= 4, max= 10, message = "Your username is too long or too short")
    private String username;

    @Column(length = 150)
    @Size(min= 4, max= 10, message = "Your password is too long or too short")
    private String password;

    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<AuthorityEntity> authorities;

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }
}
