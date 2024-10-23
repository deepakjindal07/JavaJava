package interview;

public class Reverse {

	public static void main(String[] args) {
		// How to Reverse a String in Java without using In-Build Functions

		String str = "Hello World";
		char[] c = str.toCharArray();

		int len = c.length;

		for (int a = len-1; a > 0; a--) {

			char temp = c[a];

			System.out.print(temp);
		}

	}

}
