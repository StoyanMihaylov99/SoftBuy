package com.example.softwareecommers.models.entities;

import com.example.softwareecommers.utils.SoftWareType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "soft_type")
    private SoftWareType softType;
    @Column(name = "description",columnDefinition = "TEXT",nullable = false)
    private String description;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
    @Column(name = "Company",nullable = false)
    private String company;
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

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Product setCompany(String company) {
        this.company = company;
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
        return Objects.equals(name, product.name) && softType == product.softType && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(company, product.company) && Objects.equals(picUrl, product.picUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, softType, description, price, company, picUrl);
    }
}
