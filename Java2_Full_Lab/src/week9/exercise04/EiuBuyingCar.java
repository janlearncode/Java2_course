package week9.exercise04;

import java.util.Locale;
import java.util.Scanner;

public class EiuBuyingCar {
    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        // user input:
        double carOldPrice = sc.nextDouble(), carNewPrice = sc.nextDouble();

        double downRate = sc.nextDouble() / 100.0; // car down rate
        double downPayOfOld = carOldPrice * downRate, downPayOfNew = carNewPrice * downRate;
        // the remaining loan of the old one
        double oldLoan = carOldPrice - (downPayOfOld);
        // after user pay the down price of old car, its value automatically decrease to
        // 90 after leave the showroom
        carOldPrice = carOldPrice * 0.9;

        long loanTerms = sc.nextLong(); // number of months that borrow the old car value
        double monthlyInterestRate = sc.nextDouble() / 1200.0;
        // the monthlyPay to finish the old loan
        double emi = 0;
        if (monthlyInterestRate == 0) {
            // Nếu mua trả góp 0% lãi suất, tiền mỗi tháng cứ lấy nợ gốc chia đều số tháng!
            emi = oldLoan / loanTerms;
        } else {
            // Nếu có lãi suất thì xài công thức bình thường
            emi = ((oldLoan * monthlyInterestRate) * Math.pow((1 + monthlyInterestRate), loanTerms))
                    / (Math.pow(1 + monthlyInterestRate, loanTerms) - 1);
        }
        double monthlyDepreciation = sc.nextDouble() / 100.0; // Monthly depreciation rate (percentage)

        // goal: find the month that the money amount of selling old car can finish the
        // remain loan
        // and still enough to pay the new down with no extra money
        double currentDebt = oldLoan;
        for (int i = 1; i <= loanTerms; i++) {
            // the old car value is still decrease
            carOldPrice = carOldPrice * (1 - monthlyDepreciation);
            // user pay for the loan monthly
            currentDebt = currentDebt * (1 + monthlyInterestRate) - emi;
            // checking if the money gain from selling old car is enough to pay the new car
            // down
            // if the money of selling old car after pay the debt can pay for the new down
            if (carOldPrice - currentDebt >= downPayOfNew) {
                // print the sell car month and no extra money, then stop program
                System.out.println(i + " 0");
                return;
            }

        }
        // this happen when the selling car money (after finish the loan term) isnt
        // enough to pay the new down
        double extraMoney = downPayOfNew - carOldPrice;
        System.out.println(loanTerms + " " + Math.round(extraMoney));
    }
}
