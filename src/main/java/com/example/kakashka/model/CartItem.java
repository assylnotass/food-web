package com.example.kakashka.model;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private double price;

    @ManyToOne
    private User user;

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для productName
    public String getProductName() {
        return productName;
    }

    // Сеттер для productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Геттер для quantity
    public int getQuantity() {
        return quantity;
    }

    // Сеттер для quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Геттер для price
    public double getPrice() {
        return price;
    }

    // Сеттер для price
    public void setPrice(double price) {
        this.price = price;
    }

    // Геттер для user
    public User getUser() {
        return user;
    }

    // Сеттер для user
    public void setUser(User user) {
        this.user = user;
    }
}
