package week7.excercise06;

import java.text.DecimalFormat;
/* Problem: EIUFF2 - Infinite Financial Freedom.
   Goal: Find the minimum initial fund X to sustain annual withdrawals indefinitely.
   - At t = 0: Initial Balance = X. t is time aka years
   - At end of each year: 
     1. Balance earns annual interest r%.
     2. Withdraw an amount C to cover expenses.
   - Inflation impact: Each subsequent withdrawal increases by f% per year.
   - Definition of "Indefinite": The fund must last at least 10,000 years.
   Constraint: Find X so that Balance >= 0 for all 10,000 years.
*/
import java.util.*;

public class FinancialFreedom2 {
    static Scanner sc = new Scanner(System.in);
    // static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        // target: X
        double deposit = 0;

        // user input:
        double yearlyRate = sc.nextDouble() / 100.0;
        double inflationRate = sc.nextDouble() / 100.0;
        long withDraw = sc.nextLong();

        // formula if draw infinity: deposit = withdraw / (rate - inflation)
        deposit = withDraw / (yearlyRate - inflationRate);

        System.out.print(Math.round(Math.ceil(deposit)));
    }

}
