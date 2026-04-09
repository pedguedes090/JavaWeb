package com.restaurant.bai5;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> database = new ArrayList<>();

    public void save(Order order) {
        database.add(order);
        System.out.println("Đã lưu đơn hàng vào DB: " + order.getCustomerName() + " - Tổng tiền: " + order.getTotalAmount());
    }
}