package basics;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		// Create a Scanner object to read input from the user
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter a string
		System.out.print("Enter a string: ");
		String input = scanner.nextLine(); // Read the input string

		// Close the scanner to prevent resource leak
		scanner.close();

		// Call the method to reverse the string and convert the first character to
		// uppercase
		String output = reverseString(input);

		// Display the output
		System.out.println("Output: " + output);
	}

	// Method to reverse the string and convert the first character to uppercase
	public static String reverseString(String input) {
		// Reverse the input string
		StringBuilder reversed = new StringBuilder(input).reverse();

		// Convert the first character to uppercase
		reversed.setCharAt(0, Character.toUpperCase(reversed.charAt(0)));

		// Return the modified string
		return reversed.toString();
	}
}
