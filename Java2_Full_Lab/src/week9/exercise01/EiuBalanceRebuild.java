package week9.exercise01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuBalanceRebuild {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        // user input
        int months = sc.nextInt();
        double userMonthlyIncome[] = monthlyEarns(months);
        double monthlySpending = sc.nextDouble();
        double interestRate = sc.nextDouble() / 1200.0, inflation = sc.nextDouble() / 1200.0;
        // the pool that store user balance
        double pool = 0;

        // a loop to calculate user final balance through their two period
        // working & resting

        for (int i = 0; i < 2 * months; i++) {
            // checking which period it is and adding the income if yes
            double currentIncome = 0;
            if (i < months) // if it is period 1: working
            {
                currentIncome = userMonthlyIncome[i];
            } else // if not, its period 2 and user have no income
            {
                currentIncome = 0;
            }
            // adding the remaining money to the pool after spending for expense and
            // subtituted by interest
            double remainingMoney = currentIncome - monthlySpending;
            pool = (pool + remainingMoney) * (1 + interestRate);
            // update monthly expense due to inflation
            monthlySpending = monthlySpending * (1 + inflation);

        }

        // out loop, print output
        if (pool < 0) {
            System.out.println(0);
        } else {
            System.out.println(df.format(pool));
            // System.out.println(Math.round(pool2));
        }
    }

    // array that store user earning each month
    public static double[] monthlyEarns(int months) {
        double[] monthlyIncome = new double[months];
        for (int i = 0; i < monthlyIncome.length; i++) {
            monthlyIncome[i] = sc.nextDouble();
        }

        return monthlyIncome;
    }
}
