package week8.exercise01;

import java.text.DecimalFormat;
import java.util.Scanner;
/* Question: user want to buy a house with N vnd, they have M vnd, and want to borrow money (N-M) form the bank
    with r interest rate for K. Calculate and output the amount of money that user have to pay for each months */

public class EiuBuyHouse {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // target output:
        double monthlyPay = 0;
        // user's input:
        long borrowAmount = sc.nextLong(), havingAmount = sc.nextLong();
        double debt = borrowAmount - havingAmount;
        int months = sc.nextInt();
        double rawMonthlyPay = debt / months;
        double interestRate = sc.nextDouble() / 100.0;
        // loop calculate monthly pay and print it out
        for (int i = 1; i <= months; i++) {
            // update this month interest
            double interest = interestRate * debt;
            // this month payment
            monthlyPay = rawMonthlyPay + interest;
            sb.append(i + " ").append(Math.round(monthlyPay)).append("\n");
            // update remaining debt
            debt = debt - rawMonthlyPay;
        }
        System.out.print(sb.toString());
    }
}
