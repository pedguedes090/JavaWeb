//# Báo cáo phân tích giải pháp Dependency Injection cho NotificationService
//
//## 1. Bối cảnh bài toán
//
//Hệ thống Cyber Center cần gửi thông báo **trừ tiền thành công** đến khách hàng sau khi thanh toán hoặc nạp giờ. Hiện tại có hai kênh gửi thông báo chính:
//
//        - `EmailSender`
//        - `SmsSender`
//
//        `NotificationService` sẽ phụ trách điều phối việc gửi thông báo qua các kênh này. Vấn đề đặt ra là nên chọn cách **tiêm phụ thuộc (Dependency Injection)** nào là phù hợp nhất giữa các cách phổ biến như:
//
//        - Constructor Injection
//- Field Injection
//- Setter Injection
//
//        Ngoài ra, hệ thống còn có bẫy dữ liệu: **dịch vụ SMS có thể bị mất kết nối giữa chừng**, nên giải pháp được chọn phải hỗ trợ thiết kế dễ kiểm soát lỗi, dễ test và dễ mở rộng.
//
//---
//
//        ## 2. Mục tiêu thiết kế
//
//Thiết kế `NotificationService` theo hướng:
//
//        - tách biệt trách nhiệm giữa service và sender
//- áp dụng DI để giảm phụ thuộc chặt
//- dễ test
//- dễ bảo trì
//- dễ xử lý trường hợp lỗi khi SMS bị ngắt kết nối
//
//---
//
//        ## 3. Phân tích yêu cầu nghiệp vụ
//
//### 3.1 Input
//
//Hệ thống cần các dữ liệu đầu vào như:
//
//        - `username`: tên người dùng
//- `email`: email người nhận
//- `phone`: số điện thoại người nhận
//- `amount`: số tiền vừa bị trừ
//- `message`: nội dung thông báo
//
//Ví dụ:
//
//        ```text
//        username = "nguyenvana"
//email = "vana@gmail.com"
//phone = "0988888888"
//amount = 15000
//message = "Bạn đã bị trừ 15.000 VNĐ do sử dụng máy trạm."
//        3.2 Output mong đợi
//
//Kết quả đầu ra có thể là:
//
//Gửi Email thành công
//Gửi SMS thành công
//Email thành công nhưng SMS thất bại
//Cả hai đều thất bại
//Ghi log lỗi để kiểm tra sau
//
//Ví dụ:
//
//Thông báo gửi thành công qua Email.
//Thông báo SMS thất bại do mất kết nối dịch vụ.
//4. Hai giải pháp DI cần so sánh
//
//Dưới đây là hai giải pháp tiêu biểu:
//
//Giải pháp 1: Constructor Injection
//Giải pháp 2: Field Injection
//
//        Ngoài ra, Setter Injection cũng sẽ được nhắc đến ngắn gọn để đối chiếu.
//
//5. Giải pháp 1: Constructor Injection
//5.1 Ý tưởng
//
//Dependency được truyền vào ngay khi tạo object thông qua constructor.
//
//5.2 Ví dụ
//@Service
//public class NotificationService {
//
//    private final EmailSender emailSender;
//    private final SmsSender smsSender;
//
//    public NotificationService(EmailSender emailSender, SmsSender smsSender) {
//        this.emailSender = emailSender;
//        this.smsSender = smsSender;
//    }
//
//    public void notifySuccess(String email, String phone, String message) {
//        emailSender.send(email, message);
//        smsSender.send(phone, message);
//    }
//}
//5.3 Đặc điểm
//dependency là bắt buộc
//object luôn ở trạng thái đầy đủ ngay khi được tạo
//dễ test bằng mock
//phù hợp với best practice của Spring hiện nay
//6. Giải pháp 2: Field Injection
//6.1 Ý tưởng
//
//Dùng @Autowired trực tiếp trên biến thành viên.
//
//6.2 Ví dụ
//@Service
//public class NotificationService {
//
//    @Autowired
//    private EmailSender emailSender;
//
//    @Autowired
//    private SmsSender smsSender;
//
//    public void notifySuccess(String email, String phone, String message) {
//        emailSender.send(email, message);
//        smsSender.send(phone, message);
//    }
//}
//6.3 Đặc điểm
//viết ngắn hơn
//ít code hơn lúc ban đầu
//nhưng dependency bị ẩn
//khó test hơn
//khó kiểm soát tính bắt buộc của dependency
//7. Bảng so sánh Constructor Injection và Field Injection
//Tiêu chí        	                 Constructor Injection               	            Field Injection
//Cách tiêm phụ thuộc	                 Qua constructor	                                Gắn trực tiếp vào field bằng @Autowired
//Mức độ minh bạch	                 Rõ ràng, nhìn constructor là biết class cần gì	    Không rõ ngay, phải xem field bên trong
//        Tính bắt buộc của dependency	     Rất tốt, dependency bắt buộc phải có	            Kém hơn, có thể khó nhận ra dependency nào là bắt buộc
//        Khả năng test unit	                 Rất dễ mock bằng tay hoặc framework test	        Khó hơn vì phải dùng reflection hoặc Spring context
//        Độ an toàn thiết kế	                 Cao, object được tạo ra ở trạng thái hoàn chỉnh	Thấp hơn, object có thể bị phụ thuộc vào việc inject sau
//        Hỗ trợ final	                     Có, rất phù hợp	                                Không phù hợp vì field thường không để final
//Loose Coupling	                     Tốt	                                            Trung bình
//Khả năng bảo trì	                 Dễ bảo trì	                                        Kém hơn khi dự án lớn
//Best Practice hiện nay	             Được khuyến nghị mạnh	                            Không được khuyến nghị bằng constructor
//Dễ phát hiện lỗi cấu hình	         Dễ hơn, lỗi lộ ra ngay khi khởi tạo Bean	        Có thể phát hiện muộn hơn
//
//
//Phân tích ưu điểm và nhược điểm
//8.1 Constructor Injection
//Ưu điểm
//Rõ ràng dependency của class
//Dễ kiểm thử
//                Dễ dùng với final
//Hạn chế null dependency
//Hỗ trợ thiết kế immutable tốt hơn
//Phù hợp với nguyên lý thiết kế hiện đại
//Nhược điểm
//Phải viết constructor
//Nếu class có quá nhiều dependency thì constructor sẽ dài
//8.2 Field Injection
//Ưu điểm
//Viết nhanh
//Gọn khi demo hoặc ví dụ nhỏ
//Ít boilerplate hơn
//Nhược điểm
//Khó test unit
//Dependency bị ẩn
//Khó kiểm soát trạng thái hợp lệ của object
//Không phù hợp với best practice trong hệ thống backend lớn
//Dễ dẫn đến thiết kế thiếu chặt chẽ