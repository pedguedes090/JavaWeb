package com.restaurant.bai2.controller;

import com.restaurant.bai2.common.Dish;
import com.restaurant.bai2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bai2")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public String showDishList(Model model) {
        List<Dish> dishes = dishService.getAllDishes();

        model.addAttribute("dishes", dishes);

        return "dish-list";
    }
}