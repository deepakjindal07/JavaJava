package interview;

import java.util.Scanner;

public class Pyramid1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			} System.out.println();
//		}
//		scan.close();

		for (int i = 1; i <= rows; i++) {
			// Print spaces before the stars
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			// Print stars
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println(); // Move to the next line
		}

	}

}
