# Báo cáo phân tích: Thiết kế trang danh sách món ăn động

### 1. Định nghĩa cấu trúc đối tượng `Dish`
Để phục vụ việc hiển thị thực đơn và xử lý logic giao diện, đối tượng `Dish` (Món ăn) cần bao gồm các thuộc tính cơ bản sau:

* **`id` (Long):** Mã định danh duy nhất của món ăn.
* **`name` (String):** Tên món ăn hiển thị trên thực đơn.
* **`price` (Double / BigDecimal):** Giá của món ăn (sẽ được định dạng tiền tệ khi kết xuất trên View).
* **`available` (boolean):** Trạng thái món ăn.
    * `true`: Còn hàng (Hiển thị bình thường / Chữ xanh).
    * `false`: Hết hàng (Kích hoạt đổi màu chữ sang đỏ cảnh báo).

---

### 2. Sơ đồ luồng I/O (Input/Output) từ Controller đến View

Luồng dữ liệu di chuyển từ lúc Client gửi yêu cầu cho đến khi nhận được giao diện HTML hoàn chỉnh được Thymeleaf xử lý:

```text
[ Client / Browser ]
        │
        ▼ (1) HTTP GET request tới endpoint "/bai2/dishes"
[ DishController ] 
        │
        ▼ (2) Gọi phương thức lấy dữ liệu từ Service
[ DishService ] ───> Truy vấn DB / Lấy Mock Data ───> Trả về đối tượng List<Dish>
        │
        ▼ (3) Nhận List<Dish> và gán vào Spring Model
[ Model (Spring) ] <── Model.addAttribute("dishes", listDishes)
        │
        ▼ (4) Controller return String chứa tên view "dish-list"
[ View Resolver ] ───> Ánh xạ Prefix/Suffix tìm file "/WEB-INF/templates/dish-list.html"
        │
        ▼ (5) Giao quyền cho Thymeleaf Template Engine
[ Thymeleaf ] ───> Bước 1: Quét thẻ th:if / th:unless kiểm tra list rỗng (Bẫy dữ liệu)
              ───> Bước 2: Duyệt thẻ th:each lặp qua từng phần tử Dish
              ───> Bước 3: Đánh giá biểu thức toán tử 3 ngôi (Trạng thái màu sắc)
              ───> Bước 4: Binding dữ liệu (id, name, price) vào mã HTML tĩnh
        │
        ▼ (6) Trả về Response chứa file HTML đã được render động hoàn chỉnh
[ Client / Browser ] <── Hiển thị bảng danh sách món ăn hoặc thông báo "Đang cập nhật"