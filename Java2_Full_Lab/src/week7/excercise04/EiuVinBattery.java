package week7.excercise04;

import java.util.Scanner;

public class EiuVinBattery {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // target output
        long rentingPrice = 0;
        // user input:
        long batteryPrice = sc.nextLong();
        long priceWhenRecall = sc.nextLong();
        int month = sc.nextInt(); // renting months
        double interestRate = sc.nextDouble() / 100.0;

        // plan A: total interest received when send batteryPrice to the bank
        double targetProfit = batteryPrice * Math.pow((interestRate + 1), month);
        // total interest rate in N months
        double scalar = (Math.pow(interestRate + 1, month) - 1) / interestRate;
        // calculate battery renting fee so that the total profit is not lower than plan
        // A
        rentingPrice = Math.round((targetProfit - priceWhenRecall) / scalar);
        System.out.println(rentingPrice);

    }
}
