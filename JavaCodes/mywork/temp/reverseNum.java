package temp;
import java.util.Scanner;

public class reverseNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		//int num = scan.nextInt();
		String num = scan.nextLine();



		StringBuffer str1 = new StringBuffer(String.valueOf(num));
		StringBuffer rev = str1.reverse();
		System.out.println(str1);

	}

}
