package random_4;

import java.util.HashMap;
import java.util.Map;

import random_5.stream;

public class BulkReverse {

	public static void main(String[] args) {
		int num = 12345;
		// rev1(num);

		char ch = 'c';
		String maj = "Major";
		// rev2(maj);

		String sen = "Welcome to Java WorlDDD";
		// rev3(sen);
		// countUpper(sen);
		CountUsingStream(sen);

		String co = "Java is OOO";
		// rev4(co);

	}

	private static void CountUsingStream(String sen) {
	//	int n = stream.

	}

	private static void countUpper(String sen) {

		int count = 0;
		for (char s : sen.toCharArray()) {
			if (Character.isUpperCase(s)) {
				count++;
			}

		}
		System.out.println("Count of upper: " + count);

	}

	private static void rev4(String co) {
		char[] carr = co.toCharArray();

		HashMap<Character, Integer> counter = new HashMap<>();

		for (char c : carr) {
			if (counter.containsKey(c)) {
				counter.put(c, counter.get(c) + 1);
			} else {
				counter.put(c, 1);
			}

		}

		// System.out.println(counter);

		for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());

		}

	}

	private static void rev3(String sen) {
		StringBuilder sb = new StringBuilder(sen).reverse();
		String[] n = sen.split(" ");

		System.out.println(sb);

		for (String string : n) {
			System.out.println(string);
		}

	}

	private static void rev2(String maj) {
		StringBuilder sbb = new StringBuilder(maj);
		String newer = sbb.reverse().toString();

		int nlen = newer.length();
		char[] ch = newer.toCharArray();
		ch[0] = Character.toUpperCase(ch[0]);

		System.out.println(ch);

	}

	private static void rev1(int num) {
		System.out.println("Original val: " + num);
		System.out.println();
		String str = String.valueOf(num);
		char[] ch = str.toCharArray();

		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}

	}

}
