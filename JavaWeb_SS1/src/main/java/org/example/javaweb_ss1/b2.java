// @Component
// public class PlaySession {
//     private double playTime = 0;
//
//     public void addTime(double time) {
////         this.playTime += time;
//     }
// }
//
//PlaySession được đánh dấu bằng @Component, nên khi Spring quét Bean thì mặc định Bean này sẽ có scope là Singleton. Điều đó có nghĩa là trong toàn bộ ứng dụng chỉ tồn tại một object PlaySession duy nhất và tất cả các nơi cần dùng đến nó đều dùng chung đúng object đó. Đây chính là nguyên nhân gây ra hiện tượng tính nhầm tiền giữa các máy trạm.
//
//        Cụ thể, hệ thống Cyber cần mỗi người dùng hoặc mỗi máy trạm khi đăng nhập phải có một phiên chơi riêng, tức là thời gian chơi của máy 01 phải tách biệt hoàn toàn với máy 02. Nhưng do PlaySession đang là Singleton, nên toàn bộ máy trạm đều đang dùng chung biến:
//
//// private double playTime = 0;
//
//Khi máy số 01 cộng thêm thời gian chơi bằng addTime(), giá trị playTime trong object dùng chung sẽ tăng lên. Sau đó máy số 02 cũng truy cập đúng object đó, nên nó nhìn thấy cùng giá trị playTime đã bị thay đổi. Kết quả là các máy trạm không có bộ đếm riêng mà cùng chia sẻ một bộ đếm thời gian duy nhất, dẫn đến việc một máy chơi thì máy khác cũng bị tính tiền hoặc bị trừ giờ theo.
//
//Nói ngắn gọn, Bean Singleton phù hợp với những đối tượng dùng chung toàn hệ thống như service, config hoặc utility, nhưng không phù hợp với dữ liệu mang tính trạng thái riêng của từng người dùng hoặc từng phiên làm việc. PlaySession là dữ liệu theo từng phiên chơi nên nếu để mặc định Singleton thì trạng thái sẽ bị chia sẻ giữa nhiều máy, làm sai logic nghiệp vụ. Đây là lý do Spring Bean mặc định dạng Singleton gây ra hiện tượng tính nhầm tiền trong bài toán này.