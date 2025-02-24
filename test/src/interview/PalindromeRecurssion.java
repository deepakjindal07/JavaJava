package interview;

public class PalindromeRecurssion {

	public static void main(String[] args) {
		String input = "abc";
		allPossible(input.toCharArray(), 0);
	}

	private static void allPossible(char[] ch, int currentIndex) {
		// Base case: If the current index is the last character, print the permutation
		if (currentIndex == ch.length - 1)
		{
			System.out.println(String.valueOf(ch));
			System.out.println("base base");
			return;
		}

		// Recursive case: Swap each character with the current character and recurse
		for (int i = currentIndex; i < ch.length; i++)
		{
			swap(ch, currentIndex, i); // Swap characters
			allPossible(ch, currentIndex + 1); // Recurse for the next index
			swap(ch, currentIndex, i); // Backtrack (undo the swap)
		}
	}

	private static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}
