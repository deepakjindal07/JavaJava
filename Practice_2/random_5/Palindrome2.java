package random_5;
import java.util.Arrays;
import java.util.Scanner;

public class Palindrome2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();

		String orig = a;// String.valueOf(a);

		long x = Arrays.stream(a.split(" ")).count();

		System.out.println("Words"+x);

		StringBuffer str = new StringBuffer(a).reverse();
		//StringBuffer str2 = str.reverse();

		System.out.println(str);

		System.out.println((orig.equals(str.toString())?"Yes":"No"));



	}

}
