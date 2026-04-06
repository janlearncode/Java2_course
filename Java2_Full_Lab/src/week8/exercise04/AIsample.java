package week8.exercise04;

import java.util.Scanner;
import java.util.Locale;

public class AIsample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextDouble()) {
            double debt = sc.nextDouble();
            double wishedMonthlyPay = sc.nextDouble();
            int months = sc.nextInt();
            double monthlyInterest = sc.nextDouble() / 1200.0;
            double penaltyRate = sc.nextDouble() / 100.0;

            // LUẬT MỚI: Gốc chia đều và Quỹ bảo lưu
            double basePrincipal = debt / months;
            double excessPool = 0;
            int currentMonth = 1;

            while (debt > 0) {
                double currentInterest = debt * monthlyInterest;

                // Tiền nếu muốn tất toán 1 phát sạch nợ trong tháng này
                double finalPayment = debt + currentInterest;

                // TH1: Số nợ còn lại quá ít, cục tiền Y dư sức trả đứt
                if (finalPayment <= wishedMonthlyPay) {
                    debt = 0;
                }
                // TH2: Trả góp với quỹ bảo lưu
                else {
                    // 1. Tính số gốc bắt buộc phải tự móc túi ra trả tháng này
                    double requiredPrincipalToPay = basePrincipal;

                    // Lấy Quỹ bảo lưu ra "đỡ đạn" cho cái gốc bắt buộc
                    if (excessPool >= requiredPrincipalToPay) {
                        excessPool -= requiredPrincipalToPay; // Quỹ đủ sức cân hết
                        requiredPrincipalToPay = 0; // Không cần tự bỏ tiền túi
                    } else {
                        requiredPrincipalToPay -= excessPool; // Quỹ đỡ được bao nhiêu hay bấy nhiêu
                        excessPool = 0; // Cạn quỹ
                    }

                    // 2. Tính tiền dư ra (Extra cash) để đem đi đóng lố
                    double requiredCash = requiredPrincipalToPay + currentInterest;
                    double extraCash = wishedMonthlyPay - requiredCash;

                    // 3. Trừ phí phạt cho cục tiền đóng lố
                    double extraPrincipal = extraCash / (1 + penaltyRate);

                    // 4. Cập nhật lại nợ thực tế
                    debt -= (requiredPrincipalToPay + extraPrincipal);

                    // 5. Đổ cái gốc trả lố vào Quỹ bảo lưu cho tháng sau xài
                    excessPool += extraPrincipal;
                }

                sb.append(currentMonth).append(" ").append(Math.round(debt)).append("\n");
                currentMonth++;
            }
            System.out.print(sb.toString());
            sb.setLength(0); // Dọn dẹp StringBuilder cho test case tiếp theo
        }
        sc.close();
    }
}
