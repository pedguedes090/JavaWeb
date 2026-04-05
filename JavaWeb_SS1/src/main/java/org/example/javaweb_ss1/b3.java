//## Dữ liệu đầu vào (Input)
//
//Hệ thống cần nhận các thông tin sau:
//
//username: tên tài khoản người dùng gọi món
//foodName: tên món ăn khách muốn gọi
//quantity: số lượng món ăn
//
//Ví dụ:
//
//username = "nguyenvana"
//foodName = "Mì xào bò"
//quantity = 1
//        ## Kết quả mong đợi (Output)
//
//Kết quả đầu ra nên thể hiện được:
//
//đặt món thành công hay thất bại
//lý do thất bại nếu có
//số dư còn lại sau khi trừ tiền
//số lượng tồn kho còn lại sau khi xuất món
//
//Ví dụ output thành công:
//
//Đặt món thành công
//Món: Mì xào bò
//Số lượng: 1
//Số tiền đã trừ: 25000
//Số dư còn lại: 50000
//
//Ví dụ output thất bại:
//
//Đặt món thất bại: Mì xào bò đã hết hàng
//
//hoặc:
//
//Đặt món thất bại: Số dư tài khoản không hợp lệ
//
//hoặc:
//
//Đặt món thất bại: Tài khoản không đủ tiền
//
//## Phân tích các trường hợp lỗi (Bẫy dữ liệu)
//# Trường hợp 1: Kho trả về số lượng bằng 0
//
//Ví dụ khách gọi món "Mì xào bò" nhưng database trả về:
//
//quantity = 0
//
//Khi đó hệ thống phải:
//
//dừng xử lý ngay
//không trừ tiền
//không tạo đơn
//trả về thông báo: "Mì xào bò đã hết hàng"
//        # Trường hợp 2: Số dư tài khoản âm
//
//Ví dụ database tài khoản trả về:
//
//balance = -10000
//
//Đây là dữ liệu bất thường. Hệ thống phải:
//
//coi là lỗi dữ liệu
//không tiếp tục trừ tiền
//không tạo đơn
//trả về thông báo: "Số dư tài khoản không hợp lệ"
//        # Trường hợp 3: Số dư không đủ thanh toán
//
//Ví dụ:
//
//giá món = 25000
//quantity = 2
//tổng tiền = 50000
//balance = 30000
//
//Hệ thống phải:
//
//từ chối đặt món
//không trừ kho
//không trừ tiền
//thông báo: "Tài khoản không đủ tiền"
//        # Trường hợp 4: Món ăn không tồn tại
//
//Nếu truy vấn kho không tìm thấy "Mì xào bò" thì cần:
//
//báo lỗi món không tồn tại
//không tiếp tục xử lý
//# Trường hợp 5: Số lượng gọi món không hợp lệ
//
//Ví dụ:
//
//quantity <= 0
//
//Hệ thống phải:
//
//từ chối yêu cầu
//báo lỗi "Số lượng gọi món phải lớn hơn 0"
//
//
//        ## Các bước xử lý logic
//
//Có thể mô tả luồng xử lý theo dạng gạch đầu dòng như sau:
//
//Nhận yêu cầu gọi món từ người dùng gồm username, foodName, quantity
//Kiểm tra dữ liệu đầu vào:
//username không được rỗng
//foodName không được rỗng
//quantity phải > 0
//Truy vấn kho qua InventoryRepository để lấy số lượng còn lại của món ăn
//Nếu món không tồn tại hoặc số lượng kho = 0:
//trả về lỗi hết hàng hoặc không tồn tại
//kết thúc xử lý
//Kiểm tra số lượng trong kho có đủ đáp ứng số lượng gọi không
//Truy vấn giá món ăn từ kho
//Tính tổng tiền = giá * số lượng
//Truy vấn số dư tài khoản từ UserAccountRepository
//Nếu số dư âm:
//trả về lỗi dữ liệu tài khoản không hợp lệ
//kết thúc xử lý
//Nếu số dư < tổng tiền:
//trả về lỗi không đủ tiền
//kết thúc xử lý
//Nếu hợp lệ:
//trừ tiền tài khoản
//trừ số lượng trong kho
//Trả về kết quả đặt món thành công