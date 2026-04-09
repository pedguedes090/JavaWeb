package com.restaurant.bai2.service;

import com.restaurant.bai2.common.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        // Giả lập dữ liệu từ Database
        dishes.add(new Dish(1L, "Phở Bò Kobe", 150000.0, true));
        dishes.add(new Dish(2L, "Cơm Rang Dưa Bò", 45000.0, true));
        dishes.add(new Dish(3L, "Bún Chả Hà Nội", 50000.0, false));
        dishes.add(new Dish(4L, "Trà Đá Mùa Thu", 5000.0, false));

        return dishes;
    }
}