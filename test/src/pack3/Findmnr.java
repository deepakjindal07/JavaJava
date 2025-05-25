package pack3;

import java.util.Arrays;

public class Findmnr {

	public static void main(String[] args) {

		String text = "Listen";
		String text2 = "netsiL";

		char[] ch1 = text.toLowerCase().toCharArray();
		char[] ch2 = text.toLowerCase().toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		if (Arrays.equals(ch1, ch2))
		{
			System.out.println("Yes");
		} else
		{
			System.out.println("No");
		}

	}
}
