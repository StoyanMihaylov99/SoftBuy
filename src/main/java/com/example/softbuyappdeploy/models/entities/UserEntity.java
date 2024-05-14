package com.example.softbuyappdeploy.models.entities;

import com.example.softbuyappdeploy.utils.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "created",nullable = false)
    private String created;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Product> products;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;

    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public UserEntity setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }


    public String getCreated() {
        return created;
    }

    public UserEntity setCreated(String created) {
        this.created = created;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + getId() +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
