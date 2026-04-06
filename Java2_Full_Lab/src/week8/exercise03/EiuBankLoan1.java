package week8.exercise03;

import java.util.Scanner;

/* user borrow X vnd form bank with rate of r% per year
   they want to pay max of Y vnd monthly, how long could they pay off
    the loan? */
public class EiuBankLoan1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // target output: find the number of month:
        int months = 1;
        // user input:
        long borrow = sc.nextLong(); // user borrow X
        long wishedMonthlyPay = sc.nextLong(); // user want to pay Y each month
        // user enter yearly rate
        // but convert directly to monthly rate
        double monthlyInterest = sc.nextDouble() / 1200;

        // a loop to find the month that user finish the debt
        double currentDebt = borrow;
        while (currentDebt > 0) {
            // calculate this month interest
            double interest = currentDebt * monthlyInterest;
            // update current debt
            currentDebt = currentDebt - (wishedMonthlyPay + interest);
            // update month
            months++;
        }
        System.out.println(months);
    }
}
