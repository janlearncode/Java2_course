package week9.exercise02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuRetire2 {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        // user input:
        int monthsWork = sc.nextInt();
        double interestRate = sc.nextDouble() / 1200.0, inflation = sc.nextDouble() / 1200.0;
        double userMonthlyIncome[] = incomeInput(monthsWork);

        // variables for binary sreach
        double maxPayGuess = 0;
        double highGuess = 1e15, lowGuess = 0;
        double epsilon = 1e-15;

        // a loop to find the exact maximum initial amonut that user may spend
        // which help their pool not to be out of money before 1200th months
        for (int i = 1; i <= 100; i++) {
            maxPayGuess = (highGuess + lowGuess) / 2;

            double remainingBalance = balanceAfterRetire(monthsWork, userMonthlyIncome, interestRate, maxPayGuess,
                    inflation);

            if (remainingBalance < 0) {
                highGuess = maxPayGuess;
            } else {
                lowGuess = maxPayGuess;
            }
        }

        // print out the target output
        double maxInitialPay = Math.floor(maxPayGuess);
        System.out.println(df.format(maxInitialPay));

    }

    // a method calculate user pool after 1200 months based on guessing initial
    // expenses
    public static double balanceAfterRetire(int months, double[] userMonthlyIncome, double interestRate,
            double spendingMonthly, double inflation) {
        double pool = 0;
        for (int i = 0; i < 1200; i++) {
            double currentIncome = 0;
            // checking which period it is and adding the income if yes
            if (i < months) // if it is in working period
            {
                currentIncome = userMonthlyIncome[i];
            } else // if not, it is resting period, no income
            {
                currentIncome = 0;
            }
            // adding the remaining money to the pool after spending for expense and
            // subtituted by interest
            pool = (pool + currentIncome - spendingMonthly) * (1 + interestRate);
            // update monthly expense due to inflation
            spendingMonthly = spendingMonthly * (1 + inflation);

        }
        return pool;
    }

    // an array method for storing user income input
    public static double[] incomeInput(int months) {
        double income[] = new double[months];
        for (int i = 0; i < income.length; i++) {
            income[i] = sc.nextDouble();
        }
        return income;
    }

}
