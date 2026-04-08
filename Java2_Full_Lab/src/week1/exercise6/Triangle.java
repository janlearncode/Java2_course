package week1.exercise6;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // user input:
        int numberOfInteger = sc.nextInt();

        // create the array with its length = number of int
        int numberList[] = new int[numberOfInteger];

        // enter those int in the array
        for (int i = 0; i < numberList.length; i++) {
            numberList[i] = sc.nextInt();
        }

        // MOST IMPORTANT: sorted that array to increasing
        // This allow us to check only one condition: (smaller1 + smaller2) > bigger =>
        // one triangle
        Arrays.sort(numberList);

        int triangle = 0;

        // The triple stairs loop (nested loop) - never out of bound

        // The outer loop - i will take the smallest int aka smaller1
        for (int i = 0; i < numberList.length; i++) {

            // The middle one - j will the the smaller2
            // start form i + 1 so it will not overlap the previous int
            for (int j = i + 1; j < numberList.length; j++) {

                // The innermost loop, k will take the biggest one
                // start form j + 1 so it will not overlap smaller1 and 2
                for (int k = j + 1; k < numberList.length; k++) {

                    /*
                     * The reason why not out of bound when j & k is the int behind i:
                     * They are the conditions, if i is the last element in array => so j & k
                     * not exist => those for loops breaks
                     */

                    // checking the isTriangle condition
                    if (numberList[i] + numberList[j] > numberList[k]) {
                        triangle++;
                    }
                }
            }
        }

        // print out the last result
        System.out.println(triangle);
    }
}