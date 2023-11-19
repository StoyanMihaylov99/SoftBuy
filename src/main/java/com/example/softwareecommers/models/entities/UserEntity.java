package com.example.softwareecommers.models.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "created",nullable = false)
    private String created;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Product> products;

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

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
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
                ", firstName='" + firstName +'\'' +
                ", lastName='" + lastName +'\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(created, that.created) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, firstName, lastName, email, created, products);
    }
}
