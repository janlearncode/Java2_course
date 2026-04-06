package week1.exercise4;
import java.util.Scanner;

public class EveryNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Nhập số lượng bộ dữ liệu (Test Case)
        if (!sc.hasNextInt()) return; 
        int testCase = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {
            boolean flag = true;
            
            // 2. Gọi hàm saveNumber để vừa nhập dữ liệu vừa "điểm danh" luôn
            int array[] = saveNumber();

            // 3. KIỂM TRA TỜ PHIẾU ĐIỂM DANH:
            // array.length chính là (toN + 1). Ta quét từ 1 đến toN.
            for (int j = 1; j < array.length; j++) {
                // Nếu có bất kỳ ô nào bằng 0 -> Số đó chưa từng xuất hiện!
                if (array[j] == 0) {
                    flag = false; // Đánh dấu là thiếu quân số
                    break;        // Thiếu 1 ông là đủ kết luận rồi, nghỉ sớm!
                }
            }

            // 4. CHỐT ĐƠN:
            if (flag == false) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    public static int[] saveNumber() {
        // M: Số lượng con số sẽ nhập vào
        int length = sc.nextInt(); 
        // N: Bộ số cần kiểm tra (từ 1 đến N)
        int toN = sc.nextInt();

        // TẠO TỜ PHIẾU ĐIỂM DANH (Mảng đánh dấu):
        // Tại sao lại là toN + 1? Để index cao nhất của mảng khớp đúng với số toN.
        int arrayMain[] = new int[toN + 1];

        for (int i = 0; i < length; i++) {
            int element = sc.nextInt();
            
            // CHỈ QUAN TÂM NHỮNG Ô TRONG PHẠM VI 1 ĐẾN N:
            // Những số lớn hơn N thì kệ nó, không nằm trong bộ bài cần kiểm tra.
            if (element <= toN && element >= 1) {
                // ĐÁNH DẤU: Thấy số nào thì cộng 1 vào ô có số thứ tự đó.
                // Ví dụ: Nhập số 3 thì ô arrayMain[3] sẽ tăng lên.
                arrayMain[element]++;
            }
        }
        // Trả tờ phiếu điểm danh đã được đánh dấu xong xuôi về cho hàm main.
        return arrayMain;
    }
}