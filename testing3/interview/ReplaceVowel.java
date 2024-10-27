package interview;

import java.util.Iterator;

public class ReplaceVowel {

	public static void main(String[] args) {
		// How to Remove All Vowels from a String in Java

		// replaceVowelsWithUnderscores();
		// replaceWithInbuild();
		RemoveDupWords();

	}

	private static void RemoveDupWords() {
		String words = "I am am Rahul Rahul Ji";
		String[] wordsarr = words.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < wordsarr.length; i++) {
			for (int j = i + 1; j < wordsarr.length; j++) {

				if (wordsarr[i].equals(wordsarr[j])) {
					wordsarr[i] = "";
					// System.out.print(wordsarr[i]);

				}

			}
			System.out.print(wordsarr[i]);

		}

	}

	private static void replaceWithInbuild() {
		String str = "RepalcingSpecialCharacters  ";
		StringBuilder modifiedStr = new StringBuilder();
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		for (char c : str.toCharArray()) {
			boolean isVowel = false;
			for (char vowel : vowels) {
				if (c == vowel) {
					isVowel = true;
					break;
				}
			}

			if (isVowel) {
				modifiedStr.append('_');
			} else {
				modifiedStr.append(c);
			}
		}

		System.out.println(modifiedStr.toString());

	}

	private static void replaceVowelsWithUnderscores() {
		String str = "RepalcingSpecialCharacters  ";

		char[] abc = str.toCharArray();

		for (int i = 0; i <= abc.length - 1; i++) {
			if (abc[i] == 'a' || abc[i] == 'e' || abc[i] == 'i' || abc[i] == 'o' || abc[i] == 'u') {
				// System.out.println("Yes");
				// abc[i] = (char) Character.toUpperCase(i);

				System.out.print(abc[i] = '_');

			} else {
				System.out.print(abc[i]);
			}

		}

	}
}
