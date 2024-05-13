package com.example.softbuyappdeploy.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;
    @ManyToMany
    private Set<Product> purchasedProducts;

    public Order() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public Order setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }


    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public Order setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
        return this;
    }

    public Set<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public Order setPurchasedProducts(Set<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
        return this;
    }
}
