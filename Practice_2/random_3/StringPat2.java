package random_3;

import java.util.Arrays;

public class StringPat2 {

	public static void main(String[] args) {
		String str1 = "Listen";
		String str2 = "Indian";

		char[] c1 = str1.toLowerCase().toCharArray();
		char[] c2 = str2.toLowerCase().toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);
		System.out.println(Arrays.equals(c1, c2) ? "Anagram hai" : "Anagram nahi h");

	}
}
