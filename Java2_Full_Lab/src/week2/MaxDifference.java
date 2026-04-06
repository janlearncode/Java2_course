package week2;

import java.util.Scanner;

public class MaxDifference {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // target
        int maxDifference = Integer.MIN_VALUE;
        int currentMaxDiff = Integer.MIN_VALUE;
        int totalNumber = sc.nextInt();
        int numberList[] = new int[totalNumber];
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = sc.nextInt();
        }
        // find max Diff
        for (int i = 0; i < numberList.length; i++) {
            if ((i) == numberList.length) {
                break;
            }
            currentMaxDiff = numberList[i + 1] - numberList[i];
            maxDifference = Math.max(currentMaxDiff, maxDifference);
        }
        System.out.println(maxDifference);
    }
}
