package com.restaurant.bai3.controller;

import com.restaurant.bai2.common.Dish;
import com.restaurant.bai3.service.AdminDishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    private final AdminDishService adminDishService;

    public AdminDishController(AdminDishService adminDishService) {
        this.adminDishService = adminDishService;
    }

    @GetMapping("/dishes")
    public String showAdminDishList(Model model) {
        List<Dish> dishes = adminDishService.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "admin-dish-list"; // View A
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Dish dish = adminDishService.getDishById(id);

        // BẪY DỮ LIỆU: Nếu ID không tồn tại
        if (dish == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish"; // View B
    }

    @PostMapping("/edit")
    public String processEditForm(@ModelAttribute("dish") Dish updatedDish, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật món ăn thành công!");
        return "redirect:/bai3/dishes";
    }
}