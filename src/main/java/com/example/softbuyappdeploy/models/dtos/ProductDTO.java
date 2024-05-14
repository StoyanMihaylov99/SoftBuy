package com.example.softbuyappdeploy.models.dtos;



import com.example.softbuyappdeploy.utils.SoftWareType;

import java.math.BigDecimal;

public class ProductDTO {
    private String id;
    private String name;
    private SoftWareType softType;
    private String description;
    private BigDecimal price;
    private String owner;
    private String picUrl;

    public ProductDTO() {
    }
    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public SoftWareType getSoftType() {
        return softType;
    }

    public ProductDTO setSoftType(SoftWareType softType) {
        this.softType = softType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public ProductDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public ProductDTO setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public ProductDTO setId(String id) {
        this.id = id;
        return this;
    }

}




