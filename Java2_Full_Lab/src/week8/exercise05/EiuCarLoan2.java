package week8.exercise05;

import java.text.DecimalFormat;
import java.util.*;

/**
 * PROBLEM SUMMARY: EIUCARLOAN2 - Car Upgrading Strategy
 * * Scenario:
 * User bought an Old Car with a loan and plan to sell it at month 'k'.
 * The goal is to find the exact Annual Interest Rate so that at month 'k',
 * the money from selling the Old Car is exactly enough to:
 * 1. Pay off the remaining loan balance of the Old Car.
 * 2. Pay the down payment for a New Car.
 * * Rules & Formulas:
 * - Down Payment (for both old and new cars) = Price * (m / 100)
 * - Initial Debt of Old Car = Old Car Price - Down Payment
 * - Car Depreciation: The car immediately loses 10% of its value upon purchase.
 * After that, it depreciates by 'L' percent every month.
 * - Loan Repayment: Uses the standard EMI (Equated Monthly Installment)
 * formula.
 * * Target Equation at month 'k':
 * Current Old Car Value == Remaining Debt + New Car Down Payment
 * * Inputs:
 * P (Old car price), New_P (New car price), m (Down payment %),
 * n (Loan term in months), k (Selling month), L (Monthly depreciation %)
 * * Output:
 * The estimated Annual Interest Rate (rounded to 2 decimal places).
 */
public class EiuCarLoan2 {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.0000");

    public static void main(String[] args) {
        // target output
        double bankRate = 0;

        // user input:
        double carOldPrice = sc.nextDouble(), carNewPrice = sc.nextDouble();
        double downRate = sc.nextDouble() / 100.0; // car down rate
        long loanTerms = sc.nextLong(); // number of months that borrow the old car value
        long timeSellOld = sc.nextLong(); // the time when sell the old car
        double monthlyDepreciation = sc.nextDouble() / 100.0; // Monthly depreciation rate (percentage)

        // variables for binary sreach
        double highGuess = 1.0, lowGuess = 0;
        double guessingTarget = 0;
        double epsilon = 1e-10;

        // calculate fixed price
        double newCarDeposit = carNewPrice * downRate; // calculate the deposit money for new car
        double oldCarDebt = carOldPrice - (carOldPrice * downRate); // the remaining debt of old one

        // calculate the current price of old car when sell it at k month
        double oldSellPrice = carOldPrice * 0.9; // when user already bought the old one, its price automatically drop
                                                 // by
                                                 // 10%
        // the price after that decreased by l% each month
        oldSellPrice = oldSellPrice * Math.pow((1 - monthlyDepreciation), timeSellOld -1);
        // can do this instead:
        /*
         * for (int i = 1; i <= timeSellOld; i++) {
         * // sellingPrice = sellingPrice - (itself*decreaseRate)
         * oldSellPrice -= oldSellPrice * monthlyDepreciation;
         * }
         */

        // a loop to find the actual bank rate
        for (int i = 1; i <= 100; i++) {
            // guessing annual rate - will print this out if it a chosen one
            guessingTarget = (highGuess + lowGuess) / 2;
            // convert it to monthly rate
            double monthlyRate = guessingTarget / 12;

            // guessing totalPayment
            double totalPaymentGuess = totalPayment(monthlyRate, oldCarDebt, loanTerms, timeSellOld, newCarDeposit);
            if (totalPaymentGuess > oldSellPrice) {
                highGuess = guessingTarget;
            } else {
                lowGuess = guessingTarget;
            }

        }
        bankRate = guessingTarget;
        // printout the actual yearly bank rate
        System.out.print(df.format(bankRate));

    }

    // a method to calculate the money that can pay both the remaining debt of the
    // old car
    // and deposit for a new one
    public static double totalPayment(double interestRate, double oldCarDebt, double borrowingMonths,
            double sellCarMonth, double newCarDeposit) {
        double totalPayment = 0;
        // calculate the EMI with guessing bank rate
        double numerator = oldCarDebt * interestRate * Math.pow((1 + interestRate), borrowingMonths);
        double demominator = Math.pow((1 + interestRate), borrowingMonths) - 1;
        double emi = numerator / demominator;

        // a loop to calculate the remaining debt
        double remainingDebt = oldCarDebt;
        double currentInterest = 0, principalPrepay = 0;
        for (int i = 1; i <= (sellCarMonth-1); i++) {
            currentInterest = remainingDebt * interestRate;
            // this is monthlyPay of EMI version
            principalPrepay = emi - currentInterest;
            remainingDebt -= principalPrepay;
        }
        totalPayment = remainingDebt + newCarDeposit;
        return totalPayment;
    }

}
