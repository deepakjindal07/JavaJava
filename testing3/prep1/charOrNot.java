package prep1;
import java.util.Scanner;

public class charOrNot {

	public static void main(String[] args) {
		
		char x;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter character");
		x = scan.next().charAt(0);
		
		if (x>='a' && x<='z') {
			System.out.println("This is character");
		}
		else {System.out.println("this is not");}
	}

}
