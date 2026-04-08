package week1.exercise1;

import java.util.Scanner;

public class MoneyChange {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // user input
        long currentMoney = sc.nextLong();
        int notesNeed = 0;
        // an array contain 4 types of notes value
        int noteValue[] = { 20, 10, 5, 1 };
        while (currentMoney > 0)
        /*
         * when there still not out of money, The method is to convert
         * the current amount of money by dividing it
         * by denominations of 20, 10, 5, and 1. At each stage, take the integer part
         * of the division. Then, subtract the remainder from the total amount—the
         * result of this subtraction will be used for the next level
         */
        {
            if (currentMoney >= noteValue[0]) {
                // taking the integer part of the division
                notesNeed = (int) (currentMoney / noteValue[0]);
                // subtract the remainder from the total amount—theresult of this
                // subtraction will be used for the next level
                currentMoney -= noteValue[0] * notesNeed;
                // save the number of converted notes to output
                sb.append(20 + " ").append(notesNeed + "\n");
            }
            if (currentMoney >= noteValue[1]) {
                notesNeed = (int) (currentMoney / noteValue[1]);
                currentMoney -= noteValue[1] * notesNeed;
                sb.append(10 + " ").append(notesNeed + "\n");
            }
            if (currentMoney >= noteValue[2]) {
                notesNeed = (int) (currentMoney / noteValue[2]);
                currentMoney -= noteValue[2] * notesNeed;
                sb.append(5 + " ").append(notesNeed + "\n");
            }

            if (currentMoney >= noteValue[3]) {
                notesNeed = (int) (currentMoney / noteValue[3]);
                currentMoney -= noteValue[3] * notesNeed;
                sb.append(1 + " ").append(notesNeed + "\n");
            }

        }
        // print all the output
        System.out.println(sb.toString());
    }
}
