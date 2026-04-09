package com.restaurant.bai2.common;

public class Dish {
    private Long id;
    private String name;
    private Double price;
    private boolean available;

    public Dish() {}

    public Dish(Long id, String name, Double price, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}