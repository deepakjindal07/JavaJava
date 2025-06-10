package basics_large;

import java.util.Scanner;

public class ReverseStringCopy {
	public static void main(String[] args) {

		System.out.println("Hello there, enter your string");
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	scanner.close();

	String output = reverseString(input);
	System.out.println(output);


	}
	private static String reverseString(String input) {
		StringBuilder reversed = new StringBuilder(input).reverse();
		StringBuilder secondrev = new StringBuilder(reversed);
		return reversed.toString();
	}
}
