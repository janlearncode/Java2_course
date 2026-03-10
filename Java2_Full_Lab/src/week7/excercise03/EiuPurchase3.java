package week7.excercise03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuPurchase3 {
static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");
    public static void main(String[] args) {
        // target output:
        double monthlyPay = 0;
         // user input:
        long originalPrice = sc.nextLong();
        long prePay = sc.nextLong();
        int months = sc.nextInt();
        double interestRate = sc.nextDouble();
        double debt = originalPrice - prePay;
        
    }
}
