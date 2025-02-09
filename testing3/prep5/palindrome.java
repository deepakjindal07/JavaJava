package prep5;
import java.util.Scanner;

public class palindrome {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); // Use a more descriptive variable name

		// Convert the number to a String for easier reversal
		String strNum = String.valueOf(num);

		// Reverse the String using StringBuilder (more efficient)
		StringBuilder reversed = new StringBuilder(strNum).reverse();

		// Compare the original string with the reversed string (case-sensitive)
		if (strNum.equals(reversed.toString())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
