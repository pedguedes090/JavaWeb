package com.restaurant.bai3.service;

import com.restaurant.bai2.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminDishService {

    private final List<Dish> dishes;

    public AdminDishService() {
        dishes = new ArrayList<>();
        dishes.add(new Dish(1L, "Phở Bò Kobe", 150000.0, true));
        dishes.add(new Dish(2L, "Cơm Rang Dưa Bò", 45000.0, true));
        dishes.add(new Dish(3L, "Bún Chả Hà Nội", 50000.0, false));
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public Dish getDishById(Long id) {
        Optional<Dish> foundDish = dishes.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst();
        return foundDish.orElse(null);
    }
}