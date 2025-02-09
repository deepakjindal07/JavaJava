package prep2;

public class CharOrNot {

	public static void main(String[] args) {
		char ch = '5';

		if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
			System.out.println("Yes its a character");
		} else if  (ch >=0 && ch <=9) {
			System.out.println("Its a digit");
		} else { System.out.println("Nothing"); }

	}

}
