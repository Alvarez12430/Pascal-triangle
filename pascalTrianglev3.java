//Name: Nicholas Alvarez 
//Class: CS 145
//File: pascalTriangle.java
//Purpose: This program creates Pascal's Triangle, a triangular arrangement of numbers where each number is the sum of
// the two numbers directly above it. It generates the triangle up to a specified number of rows and 
//displays it in the console 
import java.util.Scanner;

public class pascalTrianglev3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello welcome to Pascal's Triangle program.\nPascal's Triangle give the coefficients of expanded binomials");
        System.out.println("to nth degree. n being a postive integer! ");
        // Variable to keep track of whether to continue the program
        boolean continueProgram = true;

        while (continueProgram) {
            // Prompt the user to enter the number of lines for Pascal's Triangle
            System.out.println("Please enter the number of lines you'd like to generate:");
            int no = scanner.nextInt(); // Read the input from the user

            // Find the maximum number of digits in the triangle
            int maxDigits = Integer.toString(getPascalValue(no - 1, no - 1)).length();

            int spaces = no - 1; // Initialize spaces variable to keep track of leading spaces

            // Iterate through each line of the triangle
            for (int i = 0; i < no; i++) {
                // Print leading spaces
                for (int s = 0; s < spaces; s++) {
                    System.out.print("  ");
                }

                int number = 1; // Initialize the number variable for the current line

                // Iterate through each element in the current line
                for (int j = 0; j <= i; j++) {
                    // Get the number of digits in the current number
                    int length = Integer.toString(number).length();

                    // Calculate the extra spaces needed for alignment
                    int extraSpaces = maxDigits - length;

                    // Print the extra spaces for alignment
                    for (int k = 0; k < extraSpaces; k++) {
                        System.out.print(" ");
                    }

                    // Print the current number followed by appropriate spaces
                    System.out.print(number + "   ");

                    // Calculate the next number using the binomial coefficient formula
                    number = number * (i - j) / (j + 1);
                }

                spaces--; // Decrement the number of leading spaces for the next line
                System.out.println(); // Move to the next line after printing the current line
            }

            // Prompt the user if they want to continue
            System.out.println("Do you want to continue? (Y/N)");
            String choice = scanner.next();

            // Use a switch statement to handle the user's choice
            switch (choice.toUpperCase()) {
                case "Y":
                    continueProgram = true;
                    break;
                case "N":
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the program.");
                    continueProgram = false;
                    break;
            }
        }

        // Close the scanner
        scanner.close();
        System.out.println("Program exited.");
    }

    // Method to calculate the value at row i and column j in Pascal's Triangle
    private static int getPascalValue(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        } else {
            return getPascalValue(i - 1, j - 1) + getPascalValue(i - 1, j);
        }
    }//end of main 
}//end of class
