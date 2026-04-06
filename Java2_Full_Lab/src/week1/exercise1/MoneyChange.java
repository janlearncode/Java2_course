package week1.exercise1;

import java.util.Scanner;

public class MoneyChange {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // user input
        long moneyHave = sc.nextLong();
        int notesNeed = 0;
        // an array contain 4 types of notes value
        int noteValue[] = { 20, 10, 5, 1 };
        while (moneyHave > 0) {
            if (moneyHave >= noteValue[0]) {
                notesNeed = (int) (moneyHave / noteValue[0]);
                moneyHave -= noteValue[0] * notesNeed;
                sb.append(20 + " ").append(notesNeed + "\n");
            }
            if (moneyHave >= noteValue[1]) {
                notesNeed = (int) (moneyHave / noteValue[1]);
                moneyHave -= noteValue[1] * notesNeed;
                sb.append(10 + " ").append(notesNeed + "\n");
            }
            if (moneyHave >= noteValue[2]) {
                notesNeed = (int) (moneyHave / noteValue[2]);
                moneyHave -= noteValue[2] * notesNeed;
                sb.append(5 + " ").append(notesNeed + "\n");
            }

            if (moneyHave >= noteValue[3]) {
                notesNeed = (int) (moneyHave / noteValue[3]);
                moneyHave -= noteValue[3] * notesNeed;
                sb.append(1 + " ").append(notesNeed + "\n");
            }

        }
        System.out.println(sb.toString());
    }
}
