package com.example.softbuyappdeploy.models.entities;


import com.example.softbuyappdeploy.utils.SoftWareType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name",nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "soft_type")
    private SoftWareType softType;
    @Column(name = "description",columnDefinition = "TEXT",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
    @Column(name = "owner",nullable = false)
    private String owner;
    @Column(name = "picture_url",nullable = false)
    private String picUrl;

    public Product() {
    }


    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public SoftWareType getSoftType() {
        return softType;
    }

    public Product setSoftType(SoftWareType softType) {
        this.softType = softType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public Product setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public Product setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && softType == product.softType && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(owner, product.owner) && Objects.equals(picUrl, product.picUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, softType, description, price, owner, picUrl);
    }
}
