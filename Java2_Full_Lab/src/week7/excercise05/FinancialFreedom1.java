package week7.excercise05;

import java.text.DecimalFormat;
/* question: Find the minimum initial retirement fund X.
   At t = 0, balance = X.
   Every month, the remaining balance earns interest at rate r.
   At the end of each month, withdraw an amount W to cover expenses.
   - First withdrawal (month 1): W1 = Y.
   - Subsequent withdrawals: W_t = W_{t-1} * (1 + f) due to inflation.
   The fund must be sufficient to cover exactly N-1 withdrawals.
   Goal: Find X so that after N-1 months, the balance is still >= 0 */
import java.util.*;

public class FinancialFreedom1 {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.0000");

    public static void main(String[] args) {
        // target:
        double deposit = 0;

        // variables for binary search:
        double epsilon = 1e-10;
        double currentDeposit = 0.0;
        double highGuess = 1e15, lowGuess = 0.0;

        // user input:
        double monthlyRate = sc.nextDouble()/100.0;
        double inflationRate = sc.nextDouble()/100.0;
        long withDraw = sc.nextLong();
        long months = sc.nextLong();

        // loop finding the actual deposit
        for (int i = 1; i <= 100; i++) {
            currentDeposit = (highGuess + lowGuess) / 2.0;
            double currentBalance = calculateBalance(currentDeposit, withDraw, months, monthlyRate, inflationRate);
            // find the trueDeposit
            if (currentBalance > 0) {
                highGuess = currentDeposit;
            } else {
                lowGuess = currentDeposit;
            }

        }
        deposit = currentDeposit;
        System.out.println(df.format(deposit));
    }

    // method to calculate balance with guessing deposit
    public static double calculateBalance(double guessing, long withdraw, long months, double monthlyRate,
            double inflatRate) {
        double balance = guessing;
        double currentWDraw = withdraw;
        // loop in N -1 times
        for (int i = 1; i <= (months - 1); i++) {
            // interest with currentBalance
            double interest = balance * monthlyRate;
            balance = balance + interest;
            // then withdraw amount Y
            balance = balance - currentWDraw;
            // update withdraw amount for next month:
            currentWDraw = currentWDraw * (1 + inflatRate);
            // if out of balance
            if (balance < 0) {
                return -1;
            }

        }
        return balance;
    }

}
