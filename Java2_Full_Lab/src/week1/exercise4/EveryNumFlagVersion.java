package week1.exercise4;

import java.util.Scanner;

public class EveryNumFlagVersion {
 static Scanner sc = new Scanner(System.in);
 public static void main(String[] args) {
        // input the number of test cases
        int testCase = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {
            // create the flag, suppose it is true initially
            boolean isHavingAll = true;

            // create a boolean array using the method below
            boolean array[] = saveNumber();

            // check if any position from 1 to n remains false
            for (int j = 1; j < array.length; j++) {
                // if a value is false, it means that number is missing
                if (array[j] == false) {
                    isHavingAll = false;
                    break;
                }
            }

            if (isHavingAll == false) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    public static boolean[] saveNumber() {
        // input the number of elements m
        int length = sc.nextInt();
        // input the upper bound n
        int toNumberN = sc.nextInt();

        // boolean array defaults all values to false
        boolean arrayMain[] = new boolean[toNumberN + 1];

        for (int i = 0; i < length; i++) {
            int element = sc.nextInt();

            // mark the index as true if the element is in range [1, n]
            if (element <= toNumberN && element >= 1) {
                // if exist, the value of that number (corresponding index) is true
                arrayMain[element] = true;
            }
        }
        // return the boolean marking array
        return arrayMain;
    }
}