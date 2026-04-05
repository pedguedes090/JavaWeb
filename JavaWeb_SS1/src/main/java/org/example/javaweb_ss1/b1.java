//// public class RechargeService {
////     private PaymentGateway gateway;
//
////     public RechargeService() {
////         this.gateway = new InternalPaymentGateway();
////     }
//
////     public void processRecharge(String username, double amount) {
////         gateway.pay(amount);
////         System.out.println("Nạp " + amount + " cho " + username);
////     }
//// }
//
//Đoạn sai nằm ở dòng:
//
//// this.gateway = new InternalPaymentGateway();
//
//Đây là lỗi vì class RechargeService đang tự khởi tạo dependency bằng từ khóa new, tức là hard-code trực tiếp implementation cụ thể (InternalPaymentGateway) thay vì nhận từ bên ngoài. Điều này làm cho class bị phụ thuộc chặt (tight coupling) vào một cổng thanh toán duy nhất và không thể thay đổi linh hoạt sang các cổng khác như Momo hay ZaloPay.
//
//Cách viết này vi phạm nguyên lý IoC (Inversion of Control), vì theo IoC thì class không nên tự tạo dependency cho mình mà quyền khởi tạo phải được chuyển ra bên ngoài hoặc do framework (như Spring) quản lý. Khi RechargeService tự tạo InternalPaymentGateway, nó đã tự kiểm soát toàn bộ dependency, khiến hệ thống không có khả năng “đảo ngược điều khiển”.
//
//Hậu quả là hệ thống mất tính linh hoạt: muốn thêm cổng thanh toán mới thì bắt buộc phải sửa code trong RechargeService, điều này vi phạm nguyên lý OCP (Open/Closed Principle – mở để mở rộng, đóng để sửa đổi). Ngoài ra, việc hard-code dependency cũng khiến việc test trở nên khó khăn vì không thể thay thế bằng mock hoặc fake object.
//
//        Tóm lại, lỗi chính là việc sử dụng new InternalPaymentGateway() bên trong class, dẫn đến phụ thuộc chặt, khó mở rộng, khó bảo trì, khó test và không tuân thủ IoC. Giải pháp đúng là không tự khởi tạo dependency mà nên sử dụng Dependency Injection để nhận PaymentGateway từ bên ngoài hoặc từ IoC Container của Spring.