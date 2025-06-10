package random_7;

import java.util.Scanner;

public class PasswordStrenght {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pw = scan.nextLine();
		int Upper = 0;
		int Digit = 0;

		scan.close();

		//int len = pw.length();

		char[] ch = pw.toCharArray();

		for (char c : ch)
		{
			if (Character.isUpperCase(c))
			{
				Upper++;
			} else if (Character.isDigit(c))
			{
				Digit++;
			}
		}

		if (Upper >= 1 && Digit >= 1)
		{
			System.out.println("Strong pass");
		} else
		{
			System.out.println("Weak pass");
		}

	}

}
