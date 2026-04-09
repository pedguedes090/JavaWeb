# Báo cáo phân tích: Luồng dữ liệu và Data Binding (Cập nhật thực đơn)

### 1. Mô tả luồng dữ liệu (Data Flow)

* **[View A - Danh sách]:** Người dùng click vào nút "Chỉnh sửa" của một món ăn (ví dụ ID = 2). Trình duyệt gửi request `GET /bai3/edit/2`.
* **[Controller]:** `AdminDishController` tiếp nhận request, dùng `@PathVariable` để trích xuất `id = 2` từ URL.
* **[Service]:** Controller gọi `AdminDishService.getDishById(2)`.
    * **Kịch bản 1 (Thành công):** Service tìm thấy đối tượng `Dish`. Controller đẩy đối tượng này vào Model (`model.addAttribute("dish", dish)`).
    * **Kịch bản 2 (Bẫy dữ liệu - ID ảo):** Service trả về `null` (hoặc quăng Exception). Controller dùng `RedirectAttributes` để đẩy câu thông báo lỗi vào Flash Attribute, sau đó lập tức điều hướng (Redirect) người dùng quay lại đường dẫn `/bai3/dishes`.
* **[View B - Form Chỉnh Sửa]:** Nếu thành công, Thymeleaf nhận đối tượng `Dish` từ Model. Thông qua `th:object` và `th:field`, nó tự động "bóc tách" các thuộc tính (name, price, available) và điền (binding) vào các thẻ `<input>` tương ứng trên form.

---

### 2. Các biểu thức Thymeleaf sử dụng để Data Binding

* **`th:object="${dish}"`:** Khai báo đối tượng gốc cho toàn bộ Form. Các trường bên trong (như tên, giá) sẽ tự động tham chiếu đến đối tượng này thông qua dấu `*`.
* **`th:field="*{name}"`:** Cơ chế tự động sinh code cực mạnh của Thymeleaf. Nó tự động tạo ra 3 thuộc tính HTML: `id="name"`, `name="name"`, và `value="Giá trị hiện tại"`. Nó cũng tự động xử lý trạng thái `checked` hoặc `selected` cho các loại input đặc thù như checkbox/radio dựa trên dữ liệu thật.
* **`@{|/bai3/edit/${dish.id}|}`:** Cú pháp Literal Substitution (Nội suy chuỗi) kết hợp với Link URL Expression. Giúp nối trực tiếp chuỗi URL tĩnh (`/bai3/edit/`) với biến động (`dish.id`) một cách gọn gàng mà không cần dùng dấu cộng chuỗi phức tạp.