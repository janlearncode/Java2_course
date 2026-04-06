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
        for (int i = 0; i < pointsLevel.length; i++) {
            if (points >= pointsLevel[i]) {
                System.out.println(grading[i]);
                break;
            }
        }

    }
}
