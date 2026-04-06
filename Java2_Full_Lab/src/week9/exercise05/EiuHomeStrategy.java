package week9.exercise05;

import java.util.Locale;
import java.util.Scanner;

public class EiuHomeStrategy {
    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        int planningMonth = sc.nextInt();
        double housePrice = sc.nextDouble();
        double houseDownPay = housePrice * (30.0 / 100.0);
        double houseLoan = housePrice * (70.0 / 100.0);

        double houseLoanRate = sc.nextDouble(); // fixed
        //
        double monthlyHouseRate[] = new double[8];
        for (int i = 0; i < monthlyHouseRate.length; i++) {
            monthlyHouseRate[i] = sc.nextDouble();
        }
        double monthlySavingRate[] = new double[8];
        for (int i = 0; i < monthlySavingRate.length; i++) {
            monthlySavingRate[i] = sc.nextDouble();
        }

        // a loop for binary sreach
        double guessingMonthlyPay = 0;
        double highGuess = 1e18, lowGuess = 0;
        for (int i = 1; i <= 100; i++) {
            guessingMonthlyPay = (highGuess + lowGuess) / 2.0;
            boolean isSuccess = isInTime(guessingMonthlyPay, houseDownPay, housePrice, planningMonth, monthlyHouseRate,
                    monthlySavingRate, houseLoanRate);
            if (isSuccess == true) {
                highGuess = guessingMonthlyPay;
            } else {
                lowGuess = guessingMonthlyPay;
            }

        }
        // out loop, print result:
        double result = Math.round(highGuess);
        System.out.println((long) result);

    }

    // method to find the suitable monthly pay to satisfy both requirement
    // enough to pay the down and the remaining debt
    // within the term planned
    public static boolean isInTime(double guessingPay, double down, double housePrice, int planningTerm,
            double[] monthlyHouseRate,
            double[] monthlySavingRate, double loanRate) {
        boolean success = true;
        int remainingMonth = 0;
        double currentHouseRate = 0, currentSavingRate = 0;
        // period 1: saving to pay the down
        double pool = 0;
        double loan = 0;
        for (int i = 1; i <= planningTerm; i++) {
            // is it over 5 years?
            int cycle = Math.min((i - 1) / 60, 7);
            currentHouseRate = monthlyHouseRate[cycle];
            currentSavingRate = monthlySavingRate[cycle];
           
            // update the pool with interest after a month
            pool = pool * (1 + currentSavingRate);
            // adding monthlypay to the pool
            pool += guessingPay;
            
            // is it enough to pay the down, if yes, out, go to period 2
            if (pool >= down - 1e-4) {
                remainingMonth = i;
                break;
            }
            // due to the inflation, the house price increase every month, lead to the
            // change of the down
            // and the remaining loan
            housePrice += housePrice * currentHouseRate;
            down = housePrice * (30.0 / 100.0);
            loan = housePrice * (70.0 / 100.0);
            
        }

        // check what if the loop in period 1 finish but cant pay for the down
        if (pool < down) {
            return false;
        }

        // period 2: user focus to pay for the loan, since they have pay the down
        // the house price stop increase, and the saving rate also
        loan = housePrice - pool;
        double currentDebt = loan;
        int loanTerms = planningTerm - remainingMonth;
        for (int left = 1; left <= loanTerms; left++) {

            currentDebt = currentDebt * (1 + loanRate) - guessingPay;
        }
        // checking if finish the debt or not
        if (currentDebt <= 1e-4) {
            return success;
        }
        // if out the loop and there still has the debt
        return false;

    }

}
