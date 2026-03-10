package week7.excercise01;

import java.text.DecimalFormat;
/* user prepay N vnd to get a thing with V vnd
    then user have to pay M vnd (with M = V - N) in T months with a low profit
    find the low profit (monthly), call it by r
     */

/* formula:  */
import java.util.*;

public class EiuPurchase {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.000000");

    public static void main(String[] args) {
        // variables for binary sreach, each is the guess for True Interest
        double highGuess = 1.0, lowGuess = 0.0;
        double currentGuess = 0.0;
        double epsilon = 1e-16;
        int loopTimes = (int) (Math.log(1.0 / epsilon) / Math.log(2));

        // user input variables
        long price = sc.nextLong();
        long months = sc.nextLong();
        long prepay = sc.nextLong(), debt = price - prepay;
        long monthlyPay = sc.nextLong();

        // loop finding trueInterestRate
        for (int i = 1; i <= loopTimes; i++) {
            // update currentGuess
            currentGuess = (highGuess + lowGuess) / 2;
            // call the calculateDebt method
            double foundedDebt = calculateFinalDebt(debt, months, monthlyPay, currentGuess);
            // find the trueInterestRate
            if (foundedDebt > 0) {
                highGuess = currentGuess;
            } else {
                lowGuess = currentGuess;
            }
        }
        // export the founded interest rate
        double trueInterestRate = currentGuess;
        System.out.println(trueInterestRate);

    }

    // method finding debt in the last month with Guessing Interest
    public static double calculateFinalDebt(long originDebt, long months, long monthlyPay, double guessingInterest) {
        // intro variables
        double remainDebt = originDebt;
        double interest = 0;
        // calculate the remainDebt through T months
        for (int i = 1; i <= months; i++) {
            // update interest
            interest = remainDebt * guessingInterest;
            // update remainDebt = (itself + interest) - monthlyPay
            remainDebt = ((remainDebt + interest) - monthlyPay);
        }
        return remainDebt;

    }

}
