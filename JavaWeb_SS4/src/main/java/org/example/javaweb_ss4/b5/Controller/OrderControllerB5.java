package org.example.javaweb_ss4.b5.Controller;
import org.example.javaweb_ss4.b5.Service.OrderServiceB5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai5/orders")
public class OrderControllerB5  {
    private final OrderServiceB5 orderService;
    @Autowired
    public OrderControllerB5(OrderServiceB5 orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.getOrderById(orderId);
        } catch (NumberFormatException e) {
            return "ID don hang phai la mot so";
        }
    }

    @PostMapping
    @ResponseBody
    public String createOrder() {
        return orderService.createOrder();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String cancelOrder(@PathVariable("id") String id) {
        try {
            Long orderId = Long.parseLong(id);
            return orderService.cancelOrder(orderId);
        } catch (NumberFormatException e) {
            return "ID don hang phai la mot so";
        }
    }
}