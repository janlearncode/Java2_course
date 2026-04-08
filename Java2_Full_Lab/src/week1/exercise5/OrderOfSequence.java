package week1.exercise5;

import java.util.Scanner;

public class OrderOfSequence {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // user input:
        int arrayLength = sc.nextInt(); // type the array's length
        int array[] = new int[arrayLength]; // type all elements in array
        // suppose that the given array is increasing
        
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();

        }
        // the flag to record if the array is still increasing / decreasing or not
        boolean isUp = true;
        boolean isDown = true;
        // cho chạy đến length - 1 thôi vì sau index cuối có ma nào đâu mà xét :))))
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
