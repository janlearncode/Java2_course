package week8.exercise04;

import java.text.DecimalFormat;
import java.util.*;

/* question: user borrow X vnd form bank with R rate yearly for N months
   and user can pay maximum of Y vnd monthly
   however, if they pay their loan of early, there will be a prepayment penalty fee of f% on the amount of prepay
   task: calculate & print the loan balance every month until the loan balance is 0 */
public class EiuBankLoan2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {

        // user input:
        double debt = sc.nextDouble();
        double wishedMonthlyPay = sc.nextDouble(); // max amount of money user can/ want pay monthly
        int months = sc.nextInt(), currentMonth = 1;
        double baseMonthlyPay = debt / months; // (the monthlyPay that the bank want)
        double monthlyInterest = sc.nextDouble() / 1200.0; // auto turn yearly interest to monthly

        double penaltyRate = sc.nextDouble() / 100.0;
        // a loop to calculate currentDebt each month and print it out until the debt
        // return to 0
        // since user send their own monthly pay which is higher than the required one,
        // t
        // there has a excessPool - quỹ bảo lưu
        double excessPool = 0;
        // "Excess principal payments carry over to reduce the mandatory principal of
        // future months."
        while (debt > 0) {
            // interest in this month
            double currentInterest = debt * monthlyInterest;
            // principal + interest need to pay to finish the debt in this month (if)
            double finalPayment = debt + currentInterest;

            // Case 1: its final month, no debt no penalty, happen when user wished
            // monthlyPay
            // is larger then the current debt with current Interest
            if (finalPayment <= wishedMonthlyPay) {
                debt = 0;
            }
            // Case 2: normal month, when wished monthly pay is chewed by the required
            // principal and penalty
            else {
                // this is the running variable for baseMonthlyPay in case2
                double requiredPrincipalToPay = baseMonthlyPay;
                // step 1: bring the excess pool out to handle the monthly base principal
                // case 1.1: the pool can swallow the base principal instead of using wished one
                if (excessPool >= baseMonthlyPay) {
                    excessPool = excessPool - requiredPrincipalToPay;
                    requiredPrincipalToPay = 0; // return it to 0 to make sure it wont affect the wished one in this
                                                // month
                    // and wished one automatically added to the pool in line 65 66, 68 and 73
                }
                // case 1.2 the pool dont have enough money to swallow the base monthly pay
                else {
                    requiredPrincipalToPay -= excessPool; // the base momthly pay is cutted,
                    // which will affect wish one in line 65 66
                    excessPool = 0; // the pool is out of money
                }
                // calculate extra cash
                double actualPayThisMonth = requiredPrincipalToPay + currentInterest;
                double extraCash = wishedMonthlyPay - actualPayThisMonth;

                double principalAfterPenalty = extraCash / (1 + penaltyRate);

                // update current debt
                debt -= (requiredPrincipalToPay + principalAfterPenalty);
                // add the extra money from principal after penalty to the pool
                excessPool += principalAfterPenalty;
            }
            // sb.append(currentMonth + " ").append(df.format(debt) + "\n");
            sb.append(currentMonth + " ").append(Math.round(debt) + "\n");
            currentMonth++;
        }
        System.out.println(sb.toString());
    }
}
