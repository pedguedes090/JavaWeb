package org.example.javaweb_ss4.b1.Repository;


import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public String getAllOrders() {
        return "Danh sach toan bo don hang";
    }
    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }

    public String createOrder() {
        return "Them moi don hang thanh cong";
    }
}
