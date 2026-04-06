package week8.exercise02;

import java.text.DecimalFormat;
import java.util.*;

/* user enter number of bill that they have used their credit card
   with R monthly interest and T is the moment aka the day transaction happen
   every month is regarded to have total 30days, with the first T is
   the first of the month, so 31 is the fisrt of next month, 61, 91....
   X is the amount of money of each transaction
   p/s: if X is withdraw cash, it has minus, opposite to deposit*/
public class EiuCredit {
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        // user's input
        int transactions = sc.nextInt();
        double monthlyInterestRate = sc.nextDouble();
        int cutOffMoment = sc.nextInt(); // T

        // running variable
        double balance = 0, totalDebtOfMonth = 0;
        // scan all day to calculate the debt
        long[] record = transactionRecord(cutOffMoment, transactions);
        for (int day = 1; day <= cutOffMoment; day++) {
            // update balance in every day
            balance += record[day];
            // if the record in that day is minus aka withdraw, subtitute the debt
            if (balance < 0) {
                totalDebtOfMonth += Math.abs(balance);
            }
            // finalize the interest every month (30 days),
            if (day % 30 == 0) // is it the final of the month? (deadline) and only regard the debt in that day
            {
                double interest = (totalDebtOfMonth / 30.0) * monthlyInterestRate;
                // substract the interest as a penalty to current balance, update it
                balance = balance - interest;
                // reset the debt to zero before starting new 30 days cycle
                totalDebtOfMonth = 0;
            }
        }
        // output the final balance
        System.out.println(df.format(balance));

    }

    // array to record all transaction
    public static long[] transactionRecord(int cutOffDay, int numOfTransaction) {
        long record[] = new long[cutOffDay + 1];
        // user enter their transation
        for (int i = 0; i < numOfTransaction; i++) {
            // enter the day when transaction happen
            int currentDay = sc.nextInt();
            // enter the amount of money withdraw or deposit in this day
            long amount = sc.nextLong();
            record[currentDay] += amount;
        }

        return record;
    }
}
