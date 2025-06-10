package random_5;

import java.util.Scanner;

public class reverseNum {

	public static void main(String[] args) {
		// method1();
		// method2();
		method3();

	}

	private static void method3() {
		String num = "123456";
		
	}

	private static void method2() {
		String num = "123456";
		char[] ch = num.toCharArray();

		for (int i = num.length()-1; i >= 0; i--)
		{
			System.out.print(ch[i]);
		}

	}

	@SuppressWarnings("unused")
	private static void method1() {
		Scanner scan = new Scanner(System.in);
		// int num = scan.nextInt();
		String num = scan.nextLine();

		StringBuilder Str = new StringBuilder(String.valueOf(num));
		StringBuilder newStr = Str.reverse();
		System.out.println(newStr);

	}

}
