package org.example.javaweb_ss4.b5.Service;

import org.example.javaweb_ss4.b5.Repository.OrderRepositoryB5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceB5 {

    private final OrderRepositoryB5 orderRepository;

    @Autowired
    public OrderServiceB5(OrderRepositoryB5 orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    public String createOrder() {
        return orderRepository.createOrder();
    }

    public String cancelOrder(Long id) {
        return orderRepository.cancelOrder(id);
    }
}