package week1.exercise1;

import java.util.Scanner;

public class MoneyChangeForVersion {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // user input
        long currentMoney = sc.nextLong();
        int notesNeed = 0;
        // an array contain 4 types of notes value
        int noteValue[] = { 20, 10, 5, 1 };

        /*
         * when there still not out of money, The method is to convert
         * the current amount of money by dividing it
         * by denominations of 20, 10, 5, and 1. At each stage, take the integer part
         * of the division. Then, subtract the remainder from the total amount—the
         * result of this subtraction will be used for the next level
         */
        for (int i = 0; i < noteValue.length; i++) {
            if (currentMoney / noteValue[i] > 0)
            // when currentMoney is larger than the noteValue (there division will > 0)
            // - which means there still not out of money
            {
                System.out.println(noteValue[i] + " " + currentMoney / noteValue[i]);
                // update currentMoney: it will be equal to the the remainder of the division
                currentMoney = currentMoney % noteValue[i];

            }
        }
    }
}
