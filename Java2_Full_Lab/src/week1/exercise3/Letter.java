package week1.exercise3;
import java.util.Scanner;

public class Letter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Nhập vào 2 đoạn thư (Dùng next() thay vì nextLine() vì đề bảo không có
        // khoảng trắng)
        String part1 = sc.next();
        String part2 = sc.next();

        // 2. Tính tổng chiều dài 2 đoạn nếu ghép nối tiếp bình thường (chưa trừ phần bị
        // trùng)
        int totalLetter = part1.length() + part2.length();

        // 3. Khởi tạo biến lưu kỷ lục: "Số chữ cái trùng khớp nhiều nhất"
        int overLap = 0;

        // 4. Vòng lặp dò tìm: Gọi 'i' là SỐ LƯỢNG CHỮ CÁI đem ra cắt thử.
        // i bắt đầu bằng 1 (thử cắt 1 chữ).
        // Điều kiện dừng: i không được lớn hơn chiều dài của đoạn thư ngắn nhất (vì
        // phần trùng tối đa chỉ bằng cái thư ngắn nhất thôi)
        for (int i = 1; i <= part1.length() && i <= part2.length(); i++) {

            // --- BƯỚC CẮT ĐUÔI THƯ 1 ---
            // part1.length() - i: Công thức để lùi từ cuối chuỗi lên 'i' bước.
            // Ví dụ part1 dài 16 chữ. i = 4. Nó sẽ cắt từ vị trí số 12 hốt trọn 4 chữ cuối
            // cùng.
            String last = part1.substring(part1.length() - i);

            // --- BƯỚC CẮT ĐẦU THƯ 2 ---
            // substring(0, i): Cắt từ vị trí đầu tiên (index 0) và lấy đúng 'i' chữ cái.
            String first = part2.substring(0, i);

            // --- BƯỚC SO SÁNH ---
            // Nếu cục "đuôi" vừa cắt ra giống y đúc cục "đầu"
            if (last.equals(first)) {
                // Thì ghi nhận lại số 'i' này vào kỷ lục.
                // Vì vòng lặp này 'i' cứ tăng dần lên (1, 2, 3...), nên cái chữ 'i' cuối cùng
                // lọt được vào khối if này chắc chắn là con số trùng khớp LỚN NHẤT.
                overLap = i;
            }
        }

        // 5. In kết quả cuối: Tổng số chữ ban đầu TRỪ ĐI phần bị trùng lặp lại ở giữa.
        System.out.println(totalLetter - overLap);
    }
}