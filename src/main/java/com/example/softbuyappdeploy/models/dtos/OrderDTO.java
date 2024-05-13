package com.example.softbuyappdeploy.models.dtos;


import java.time.LocalDateTime;
import java.util.Set;

public class OrderDTO {


    private String customerId;

    private Set<ProductViewDTO> purchasedProducts;
    private LocalDateTime orderDateTime;

    public OrderDTO() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderDTO setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public Set<ProductViewDTO> getPurchasedProducts() {
        return purchasedProducts;
    }

    public OrderDTO setPurchasedProducts(Set<ProductViewDTO> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
        return this;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public OrderDTO setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
        return this;
    }
}
