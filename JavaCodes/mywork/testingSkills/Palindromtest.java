package testingSkills;

import java.util.Scanner;

public class Palindromtest {

	public static void main(String[] args) {
		System.out.println("enter string, palindrome: ");
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();

		System.out.println(val);

		StringBuilder val2 = new StringBuilder(val).reverse();
		String val3 = val2.toString();

		if(val.equals(val3)) {
			System.out.println("Yes");

		}

		char[] lastd = val.toCharArray();
		lastd[lastd.length-1] = Character.toUpperCase(lastd[lastd.length-1]);


		System.out.println(lastd);

	}

}
