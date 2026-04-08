package org.example.javaweb_ss4.b4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/bai4/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap modelMap
    ) {
        modelMap
                .addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tim kiem thanh cong");

        return "productList";
    }
}
