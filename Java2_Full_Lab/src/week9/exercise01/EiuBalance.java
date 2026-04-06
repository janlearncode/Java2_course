package week9.exercise01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuBalance {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        // user input
        int months = sc.nextInt();
        double userMonthlyIncome[] = monthlyEarns(months);
        double monthlySpending = sc.nextDouble();
        double interestRate = sc.nextDouble() / 1200.0, inflation = sc.nextDouble() / 1200.0;

        // period 1: when user still at work in m months
        double saving1[] = new double[months];
        double monthlySpending1 = monthlySpending;
        double pool1 = 0;
        for (int i = 0; i < saving1.length; i++) {
            // user received their salary and directly spent it for expensesc
            saving1[i] = userMonthlyIncome[i] - monthlySpending1;
            // update the saving pool in period 1, adding the remain money after spent
            pool1 += saving1[i];
            // the pool earn interest form bank rate
            pool1 += pool1 * interestRate;
            // update the next monthly spending since it change due to inflation
            monthlySpending1 = monthlySpending1 * (1 + inflation);

        }

        // period 2: when user in vacation for m months, no monthly income
        double saving2[] = new double[months];
        double monthlySpending2 = monthlySpending1;
        double pool2 = pool1;
        for (int i = 0; i < saving2.length; i++) {
            // since there is no income during vacation, user spend money
            saving2[i] = -monthlySpending2;
            // the amount of moeny they spend directly added (substract) to their pool
            pool2 += saving2[i];
            // the pool still earn interest form bank rate
            pool2 += pool2 * interestRate;
            // update the next monthly spending since it change due to inflation
            monthlySpending2 = monthlySpending2 * (1 + inflation);

        }
        // out loop, print output
        if (pool2 < 0) {
            System.out.println(0);
        } else {
            System.out.println(df.format(pool2));
            //System.out.println(Math.round(pool2));
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
