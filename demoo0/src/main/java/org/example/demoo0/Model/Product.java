package org.example.demoo0.Model;

import java.util.Date;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private Date expirationDate;

    public Product() {
    }

    public Product(String name, int price, int quantity, Date expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
