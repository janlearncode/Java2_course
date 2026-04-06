package week9.exercise03;

import java.text.DecimalFormat;
import java.util.Scanner;
/*
 ** Problem: EIUSAVING 3 - Monthly Savings Calculation
 * * Description:
 * User deposits a fixed amount (X) at the beginning of each month for M consecutive months.
 * Interest is added to the account at the end of each chosen term.
 * If a deposit's duration exceeds the maximum term available in the bank's rate table 
 * (e.g., 12 months), it will automatically roll over. 
 * This creates a hybrid interest model: Compound interest for full max-term cycles, 
 * and Simple interest for any remaining odd months.
 * * * Goal: 
 * Find the required monthly deposit (X) to reach maturity amount (N) after M months.
 * * * Formula for the multiplier of each deposit:
 * Multiplier = (1 + (Rate_max * max_term) / 1200)^(full_cycles) * (1 + (Rate_rem * remain_months) / 1200)
 * where:
 * - max_term = 12 (the highest term in the table)
 * - full_cycles = k / 12 (number of full compound cycles)
 * - remain_months = k % 12 (remaining odd months for simple interest)
 
 * P/s; Interest will be added to account at the end of each period (not round).
 */

public class EiuSaving3 {
   static Scanner sc = new Scanner(System.in);
   static DecimalFormat df = new DecimalFormat("0.0000");

   public static void main(String[] args) {
      // target output
      double monthlySent = 0;

      // user input
      double moneyWant = sc.nextDouble();
      int depositMonths = sc.nextInt();
      double[] monthInterestRate = { 3.9, 3.92, 3.95, 3.99, 4.04, 5.54, 5.72, 5.92, 6.14, 6.38, 6.64, 6.92 };
      double totalInterestGain = 0;
      for (int i = 0; i < depositMonths; i++) {
         int k = i + 1; // k is the total months this deposit stays in the bank
         
         // 1. divide the time into full years and remaining odd months
         int fullYears = k / 12;       // number of 12-month cycles (longest term)
         int remainMonths = k % 12;    // remaining odd months
         
         // 2. calculate the multiplier for exactly 1 year (12-month term)
         double oneYearRate = 1.0 + (monthInterestRate[11] * 12.0) / 1200.0;
         
         // 3. calculate compound interest for full years using power function
         // if fullYears = 0 (less than 1 year), mult will automatically be 1
         double mult = Math.pow(oneYearRate, fullYears);
         
         // 4. calculate simple interest for the remaining odd months (if any)
         if (remainMonths > 0) {
             double oddMonthRate = 1.0 + (monthInterestRate[remainMonths - 1] * remainMonths) / 1200.0;
             // multiply the odd months' multiplier into the current amount
             mult = mult * oddMonthRate; 
         }
         
         // 5. add the final multiplier of this deposit to the total gain
         totalInterestGain += mult;
      }
      /*
       * form the original formula: moneywant = monthlysent * (1 + Rate_of_kth_month *
       * kth_month )
       * to find monthlysent, just take moneywant divive the rate
       */
      monthlySent = moneyWant / totalInterestGain;
      System.out.println(df.format(monthlySent));

   }
}
