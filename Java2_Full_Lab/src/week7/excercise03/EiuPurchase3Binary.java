package week7.excercise03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuPurchase3Binary {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        // target output:
        double monthlyPay = 0;
        // binary sreach materials
        double highGuess = 1e15, lowGuess = 0;
        double monthlyPayGuess = 0;
        double epsilon = 1e-15;

        // user input:
        long originalPrice = sc.nextLong();
        long prePay = sc.nextLong();
        int months = sc.nextInt();
        double interestRate = sc.nextDouble();
        double debt = originalPrice - prePay;

        for (int i = 1; i <= 100; i++) {
            monthlyPayGuess = (highGuess + lowGuess) / 2;
            double currentDebt = remainingDebt(monthlyPayGuess, debt, months, interestRate);
            if (currentDebt > 0) {
                lowGuess = monthlyPayGuess;
            } else {
                highGuess = monthlyPayGuess;
            }
        }
        monthlyPay = (monthlyPayGuess);
        System.out.println(df.format(Math.floor(monthlyPay)));
    }

    public static double remainingDebt(double monthlyPayGuess, double debt, int months, double rate) {
        double currentDebt = debt;

        for (int i = 1; i <= months; i++) {
            currentDebt = currentDebt * (1 + rate) - monthlyPayGuess;
        }
        return currentDebt;
    }
}
