package basics_large;
import java.util.Scanner;

public class Addition {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);


		int num1, num2, sum;
		System.out.print("enter the first number");
		num1 = sc.nextInt();
		System.out.print("Enter second number");
		num2 = sc.nextInt();
		sc.close();

		sum = num1 + num2;
		System.out.print("Addition of two numbers is:" + sum);


	}
}