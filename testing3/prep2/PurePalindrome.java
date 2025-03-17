package prep2;

import java.util.Scanner;

public class PurePalindrome {

	public static void main(String[] args) {
		System.out.println("Enter String");
		Scanner scan = new Scanner(System.in);
		String ch = scan.nextLine();

		System.out.println(IsPalindome(ch) ? "Yes" : "NO");
	}

	public static boolean IsPalindome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != 1) {
				return false;
			}
			left++;
			right--;
		}

		return true;

	}

}
