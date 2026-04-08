package org.example.javaweb_ss4.b5.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryB5 {

    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }

    public String createOrder() {
        return "Them moi don hang thanh cong";
    }

    public String cancelOrder(Long id) {
        return "Huy don hang voi ID: " + id + " thanh cong";
    }
}