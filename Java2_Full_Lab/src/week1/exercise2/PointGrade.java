package week1.exercise2;

import java.util.Scanner;

public class PointGrade {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // user input:
        int points = sc.nextInt();
        // 12 slots of grading
        int pointsLevel[] = { 90, 85, 80, 75, 70, 65, 60, 55, 53, 52, 50, 0 };
        String[] grading = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F" };
        // the progress is: checking if the given point equals (1st condition) or
        // just larger than a points level (2nd condition) - immediately print its
        // corresponding grade
        // and stop program
        for (int i = 0; i < pointsLevel.length; i++) {
            // checking condition
            if (points >= pointsLevel[i]) {
                // if satisfied, print the corresonding grade
                System.out.println(grading[i]);
                // stop program right away
                break;
            }
        }

    }
}
