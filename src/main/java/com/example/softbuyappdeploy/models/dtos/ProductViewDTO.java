package com.example.softbuyappdeploy.models.dtos;



import com.example.softbuyappdeploy.models.entities.UserEntity;
import com.example.softbuyappdeploy.utils.SoftWareType;

import java.math.BigDecimal;
import java.util.Set;

public class ProductViewDTO {
    private String id;
    private String name;
    private SoftWareType softType;
    private String description;
    private BigDecimal price;
    private String owner;
    private String picUrl;

    private Set<UserEntity> users;

    public ProductViewDTO() {
    }
    public String getName() {
        return name;
    }

    public ProductViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public SoftWareType getSoftType() {
        return softType;
    }

    public ProductViewDTO setSoftType(SoftWareType softType) {
        this.softType = softType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public ProductViewDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public ProductViewDTO setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public ProductViewDTO setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public ProductViewDTO setId(String id) {
        this.id = id;
        return this;
    }

}




