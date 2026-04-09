# Phân tích các điểm sai trong cấu hình ViewResolver (JSP sang Thymeleaf)

Có 3 lỗi sai nghiêm trọng trong đoạn code cấu hình hiện tại khiến Thymeleaf không thể hoạt động đúng:

### 1. Lỗi sai thứ nhất - Đuôi file (Suffix) không hợp lệ
* **Hiện tại:** `resolver.setSuffix(".jsp");`
* **Nguyên nhân:** Thymeleaf là một Natural Template Engine chuyên xử lý HTML/XML, chứ không phải là trình biên dịch JSP. Việc cấu hình đuôi `.jsp` sẽ khiến Thymeleaf cố gắng đọc file JSP như một template HTML, dẫn đến lỗi cú pháp hoặc không render được các tag của JSP. Cần phải đổi thành `.html`.

### 2. Lỗi sai thứ hai - Thiếu dấu gạch chéo `/` ở cuối Prefix
* **Hiện tại:** `resolver.setPrefix("/WEB-INF/views");`
* **Nguyên nhân:** Cơ chế của Spring là nối trực tiếp chuỗi Prefix + Tên View (từ Controller) + Suffix. Nếu Controller trả về view tên là `"home"`, hệ thống sẽ nối thành `/WEB-INF/viewshome.html` (thay vì `/WEB-INF/views/home.html`). Điều này khiến hệ thống không tìm thấy file và báo lỗi 404/500. Ngoài ra, theo yêu cầu bài toán, thư mục đích phải là `templates` chứ không phải `views`. Cần sửa thành `/WEB-INF/templates/`.