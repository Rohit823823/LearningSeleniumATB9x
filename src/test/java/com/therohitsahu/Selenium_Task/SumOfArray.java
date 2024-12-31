package com.therohitsahu.Selenium_Task;
import java.util.Scanner;

public class SumOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;

        // Input the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sum += array[i]; // Add each element to the sum
        }

        // Display the sum
        System.out.println("The sum of all items in the array is: " + sum);
    }
}
