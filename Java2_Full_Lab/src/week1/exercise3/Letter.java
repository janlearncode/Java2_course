package week1.exercise3;

import java.util.Scanner;

/* Question: A and B have known each other for many years, they often write to each other. A divide his letter into two parts and the second part starts withs some letters which are also at the end of the first parts,

The letter is very long, so B wants you to find the shortest possible result that is the content of the letter A sent.

Input
Including 2 lines:

+ The first line is the content of first part.

+ The second line is the content of the second part.

Each section consists of only latin characters and contains no spaces. 

Output
The shortest possible length of the letter */
public class Letter {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // user enter the first part of the letter
        String part1 = sc.next();
        // enter the second part
        String part2 = sc.next();

        // calculate the total length of both parts
        int totalLetter = part1.length() + part2.length();

        // the variable to store the total number of same characters form to parts
        int overLap = 0;
        // compare all character of two parts, stop when the times of loop is larger
        // than the
        // length of any part
        for (int i = 1; i <= part1.length() && i <= part2.length(); i++) {

            // take the tail of the 1st part
            String last = part1.substring(part1.length() - i);

            // take the head of the 2nd part
            String first = part2.substring(0, i);

            // if the current tail is same to head, there is one more overlap character
            if (last.equals(first)) {

                overLap = i;
            }
        }
        // substract the number of overLap character between 2 letters
        System.out.println(totalLetter - overLap);
    }
}