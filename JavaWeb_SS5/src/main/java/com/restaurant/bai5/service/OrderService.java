package com.restaurant.bai5.service;

import com.restaurant.bai2.common.Dish;
import com.restaurant.bai3.service.AdminDishService;
import com.restaurant.bai5.Order;
import com.restaurant.bai5.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final AdminDishService dishService;

    public OrderService(OrderRepository orderRepository, AdminDishService dishService) {
        this.orderRepository = orderRepository;
        this.dishService = dishService;
    }

    public Order processOrder(Long dishId, String customerName, int quantity) {
        Dish dish = dishService.getDishById(dishId);
        if (dish == null || !dish.isAvailable()) {
            throw new IllegalArgumentException("Món ăn không tồn tại hoặc đã hết hàng!");
        }

        double subTotal = dish.getPrice() * quantity;
        double tax = subTotal * 0.10;
        double total = subTotal + tax;

        Order order = new Order(customerName, dish.getName(), quantity, dish.getPrice(), tax, total);

        orderRepository.save(order);

        return order;
    }
}