package com.api6;

import java.util.Scanner;

public class C {
    // Function to check even or odd


    public static void checkEvenOddInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i] + " is Even.");
            } else {
                System.out.println(arr[i] + " is Odd.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[size];

        // Input the elements of the array
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if the array elements are even or odd
        checkEvenOddInArray(arr);
    }
}



