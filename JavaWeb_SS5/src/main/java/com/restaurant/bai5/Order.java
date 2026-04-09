package com.restaurant.bai5;

public class Order {
    private String customerName;
    private String dishName;
    private int quantity;
    private double unitPrice;
    private double taxAmount;
    private double totalAmount;

    public Order() {}

    public Order(String customerName, String dishName, int quantity, double unitPrice, double taxAmount, double totalAmount) {
        this.customerName = customerName;
        this.dishName = dishName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getDishName() { return dishName; }
    public void setDishName(String dishName) { this.dishName = dishName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    public double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}