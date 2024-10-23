package interview;

public class CountUpper {

	public static void main(String[] args) {
		// Java Program To Find the Number of Uppercase Letters in a String

		String str = "Hello World, I am Deepak Kumar";
		char[] ch = str.toCharArray();
		int count = 0;

		//String abc = str.is

		for (char element : ch) {

			if (Character.isUpperCase(element)) {

				count = count + 1;
			}
		}
		System.out.println(count);

	}

}
