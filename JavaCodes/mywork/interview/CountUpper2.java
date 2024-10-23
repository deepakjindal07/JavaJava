package interview;

public class CountUpper2 {

	public static void main(String[] args) {
		// Java Program To Find the Number of Uppercase Letters in a String

		String str = "Hello2 World3, I4 am Deepak Kumar";
		char[] ch = str.toCharArray();
		// int DigitCount = 1;

		ch[ch.length - 1] = Character.toUpperCase(ch[ch.length - 1]);

		System.out.println(ch);

	}

}
