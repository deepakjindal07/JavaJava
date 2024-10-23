package testingSkills;

import java.util.Arrays;
import java.util.HashSet;

public class Anagram {

	public static void main(String[] args) {

		// Anagram();
		// RevString();
		// DupArray();
		// Fibno();

	}

	private static void Fibno() {
		// Fibno series.

		int fir = 0; // 1
		int sec = 1; //
		int curr = 0; // 1

		System.out.println(fir);
		System.out.println(sec);

		for (int i = 0; i < 10; i++) {

			curr = fir + sec; //1
			sec = fir; //0
			fir = curr; //1

			System.out.println(curr);

		}

	}

	private static void DupArray() {
		// Implement a method to remove duplicates from an array.

		int[] nums = { 1, 2, 2, 4, 4, 6 };

		HashSet<Integer> correct = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			correct.add(nums[i]);

		}

		System.out.println(correct);

	}

	private static void RevString() {
		// Write a Java program to reverse a string without using built-in functions.

		String str = "HelloWorld";
		char[] ch = str.toCharArray();
		int count = 0;

		for (int i = ch.length - 1; i >= 0; i--) {

			if (ch[i] == 'o') {
				count += 1;

				while (count >= 0) {
					System.out.print("$");
					count--;
				}
			}
			System.out.print(ch[i]);

		}

	}

	private static void Anagram() {
		String one = "India";
		String two = "Indai";

		char[] one1 = one.toCharArray();
		char[] two1 = two.toCharArray();

		Arrays.sort(one1);
		Arrays.sort(two1);

		System.out.println(two1);
		System.out.println(one1);

		if (Arrays.equals(one1, two1)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println("two1");

	}

}
