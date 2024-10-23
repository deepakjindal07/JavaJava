package testingSkills;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// System.out.println();
		int x = scan.nextInt();

		scan.close();
		if (x % 2 == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}

	}
}
