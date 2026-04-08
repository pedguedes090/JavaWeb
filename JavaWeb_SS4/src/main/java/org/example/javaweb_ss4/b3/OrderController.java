package org.example.javaweb_ss4.b3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable Long id) {
        return "Chi tiet don hang so " + id;
    }
}