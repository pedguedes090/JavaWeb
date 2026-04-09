package com.restaurant.bai5.controller;

import com.restaurant.bai2.common.Dish;
import com.restaurant.bai3.service.AdminDishService;
import com.restaurant.bai5.Order;
import com.restaurant.bai5.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5")
public class DishDetailController {

    private final AdminDishService dishService;
    private final OrderService orderService;

    public DishDetailController(AdminDishService dishService, OrderService orderService) {
        this.dishService = dishService;
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public String showOrderPage(@PathVariable("id") Long id, Model model) {
        Dish dish = dishService.getDishById(id);
        if (dish == null) {
            throw new RuntimeException("Lỗi 404: Không tìm thấy món ăn với ID = " + id);
        }
        model.addAttribute("dish", dish);
        return "smart-order";
    }

    @PostMapping("/order/submit")
    public String submitOrder(
            @RequestParam("dishId") Long dishId,
            @RequestParam("customerName") String customerName,
            @RequestParam("quantity") int quantity,
            Model model) {

        Order completedOrder = orderService.processOrder(dishId, customerName, quantity);

        model.addAttribute("order", completedOrder);
        return "order-success";
    }

    @ExceptionHandler({RuntimeException.class, IllegalArgumentException.class})
    public String handleExceptions(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error-page";
    }
}