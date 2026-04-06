package week8.exercise04;

import java.text.DecimalFormat;
import java.util.*;

/* question: user borrow X vnd form bank with R rate yearly for N months
   and user can pay maximum of Y vnd monthly
   however, if they pay their loan of early, there will be a prepayment penalty fee of f% on the amount of prepay
   task: calculate & print the loan balance every month until the loan balance is 0 */
public class EiuBankLoan2WithEMI {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {

        // user input:
        double debt = sc.nextDouble();
        double wishedMonthlyPay = sc.nextDouble(); // max amount of money user can/ want pay monthly
        int months = sc.nextInt(), currentMonth = 1;
        double requiredMonthlyPay = 0; // (the monthlyPay that the bank want)2
        double monthlyInterest = sc.nextDouble() / 1200.0; // auto turn yearly interest to monthly
        // emi is required principal aka required monthly pay
        // with included monthly interest, calculate it
        // formula: numerator: debt * rate * (1 + rate)^months
        // denominator: (1 + rate)^months - 1
        double emi = debt * (monthlyInterest * Math.pow(1 + monthlyInterest, months))
                / (Math.pow(1 + monthlyInterest, months) - 1);

        double penaltyRate = sc.nextDouble() / 100.0;

        while (debt > 0) {
            // interest in this month
            double currentInterest = debt * monthlyInterest;
            // principal + interest need to pay to finish the debt in this month (if)
            double finalPayment = debt + currentInterest;

            // case 1: its final month, no debt no penalty, happen when user wished
            // monthlyPay
            // is larger then the current debt with current Interest
            if (finalPayment <= wishedMonthlyPay) {
                debt = 0;
            }
            // case 2: normal month, when wished monthly pay is chewed by the required
            // principal and penalty
            else {
                // step 1: calculate required principal = it is emi without the interest
                requiredMonthlyPay = emi - currentInterest;
                // step 2: calculate extra cash - the amount of money that wished larger than
                // required
                double extraCash = wishedMonthlyPay - emi;

                // step 3: calculate the required principal when submitted the penalty of prepay
                double principalAfterPenalty = extraCash / (1 + penaltyRate);

                // update current debt
                debt -= (requiredMonthlyPay + principalAfterPenalty);
            }
            //sb.append(currentMonth + " ").append(df.format(debt) + "\n");
            sb.append(currentMonth + " ").append(Math.round(debt) + "\n");
            currentMonth++;
        }
        System.out.println(sb.toString());
    }
}
