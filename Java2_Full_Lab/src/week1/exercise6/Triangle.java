package week1.exercise6;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Nhập số lượng phần tử N
        int numberOfInteger = sc.nextInt();
        
        // Tạo mảng có độ dài N
        int numberList[] = new int[numberOfInteger];
        
        // Vòng lặp nạp các con số vào mảng
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = sc.nextInt();
        }

        // 2. SẮP XẾP MẢNG TĂNG DẦN (Cực kỳ quan trọng!)
        // Việc sắp xếp giúp ta chỉ cần check 1 điều kiện duy nhất: (cạnh nhỏ + cạnh trung > cạnh lớn)
        Arrays.sort(numberList);

        int triangle = 0;

        // 3. BỘ BA VÒNG LẶP "BẬC THANG" - Không bao giờ Out of Bound
        
        // Vòng lặp i: Đại diện cho cạnh nhỏ nhất.
        for (int i = 0; i < numberList.length; i++) {
            
            // Vòng lặp j: Đại diện cho cạnh ở giữa. 
            // Bắt đầu từ i + 1 để không chọn trùng con số ở vị trí i.
            for (int j = i + 1; j < numberList.length; j++) {
                
                // Vòng lặp k: Đại diện cho cạnh lớn nhất.
                // Bắt đầu từ j + 1 để không chọn trùng i và j.
                for (int k = j + 1; k < numberList.length; k++) {
                    
                    /* TẠI SAO KHÔNG OUT OF BOUND?
                       Bà nhìn điều kiện dừng: 'k < numberList.length'.
                       Dù k = j + 1 hay j = i + 1, thì Java luôn check điều kiện này TRƯỚC khi chạy thân vòng lặp.
                       Nếu i nằm ở cuối mảng -> j sẽ vượt index -> điều kiện 'j < length' sai -> vòng lặp j và k KHÔNG CHẠY.
                       Vậy nên nó luôn dừng lại đúng lúc trước khi chạm vách!
                    */

                    // 4. KIỂM TRA ĐIỀU KIỆN TAM GIÁC
                    // Vì đã sort nên numberList[i] <= numberList[j] <= numberList[k]
                    // Ta chỉ cần check: Tổng 2 thằng bé có thắng được thằng lớn nhất không?
                    if (numberList[i] + numberList[j] > numberList[k]) {
                        triangle++; // Nếu thắng, đếm thêm 1 tam giác hợp lệ
                    }
                }
            }
        }
        
        // 5. In ra kết quả cuối cùng
        System.out.println(triangle);
    }
}