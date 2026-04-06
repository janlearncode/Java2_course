package week1.exercise5;

import java.util.Scanner;

public class OrderOfSequence {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // user input:
        int arrayLength = sc.nextInt();
        int array[] = new int[arrayLength];
        boolean isIncrease = true;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();

        }
        boolean isUp = true;
        boolean isDown = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1])
                isDown = false; // Thấy tăng hoặc bằng thì không thể là giảm
            if (array[i] >= array[i + 1])
                isUp = false; // Thấy giảm hoặc bằng thì không thể là tăng
        }

        if (isUp)
            System.out.println("increasing");
        else if (isDown)
            System.out.println("decreasing");
        else
            System.out.println("none");
    }
}
