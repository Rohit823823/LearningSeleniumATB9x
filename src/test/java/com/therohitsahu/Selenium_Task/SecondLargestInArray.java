package com.therohitsahu.Selenium_Task;
import java.util.Scanner;

public class SecondLargestInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Handle edge case: At least two elements are needed
        if (n < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int[] array = new int[n];

        // Input the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Initialize largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Find the largest and second largest numbers
        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        // Check if second largest was updated
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest number found (all elements may be equal).");
        } else {
            System.out.println("The second largest number in the array is: " + secondLargest);
        }
    }
}
