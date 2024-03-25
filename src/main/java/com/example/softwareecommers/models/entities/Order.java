package com.example.softwareecommers.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order{

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

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
