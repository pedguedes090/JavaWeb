package org.example.demo112.Controller;

import org.example.demo112.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/","/product"})
public class ProductController {
    @GetMapping
    public String product(Model model){
        List productList = new ArrayList();
        productList.add(new Product("1","product1","description1","manager1",null,null,10));
        productList.add(new Product("2","product2","description2","manager2",null,null,20));
        productList.add(new Product("3","product3","description3","manager3",null,null,30));
        model.addAttribute("productList",productList);
        return "product";
    }
}
