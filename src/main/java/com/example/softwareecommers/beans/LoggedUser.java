package com.example.softwareecommers.beans;

import com.example.softwareecommers.models.dtos.ProductViewDTO;

import java.util.Set;

public class LoggedUser {
    private String id;
    private String username;
    private String email;
    private Set<ProductViewDTO> products;
    private String password;

    public LoggedUser() {
    }

    public String getId() {
        return id;
    }

    public LoggedUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoggedUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public void clear(){
        this.id = null;
        this.username = null;
    }

    public Set<ProductViewDTO> getProducts() {
        return products;
    }

    public LoggedUser setProducts(Set<ProductViewDTO> products) {
        this.products = products;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoggedUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
