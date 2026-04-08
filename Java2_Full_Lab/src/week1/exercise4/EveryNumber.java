package week1.exercise4;

import java.util.Scanner;

/* Question: Check if array of m numbers have every number from 1..n

Input
T: Number of testcases (1 <= T <= 20)

For each testcase:

+ 2 integers m and n (1 <= m, n <= 10^5)

+ m integers ai (ai <= 10^9, 0<=i < m)

Output
For each testcase, print "Yes" if array has every number from 1..n, otherwise print "No" (Without quote) */
public class EveryNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // input the number of testCase
        int testCase = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {
            // create the flag, suppose that the flag is true because
            // the array satified the condition
            boolean isHavingAll = true;

            // create an array method, explain in below
            int array[] = saveNumber();

            // fast checking, if there is an element form 1 to N that not exist
            // in the given array, it fails the condition, conclude this array
            for (int j = 1; j < array.length; j++) {

                if (array[j] == 0) {
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

    public static int[] saveNumber() {
        // enter the length of the array
        int length = sc.nextInt();
        // enter the upper bound
        int toNumberN = sc.nextInt();

        int arrayMain[] = new int[toNumberN + 1];

        for (int i = 0; i < length; i++) {
            int element = sc.nextInt();

            // using Frequency Array to count the time exist of one element in array
            // checking if the element itself is smaller than the bound and larger than 1
            if (element <= toNumberN && element >= 1) {

                arrayMain[element]++;
            }
        }
        // bring the result back to the main class
        return arrayMain;
    }
}