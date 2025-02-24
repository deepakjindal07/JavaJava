package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountWordsinString9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter String of words: ");
		String str = scanner.nextLine();

		System.out.println("Enter Nth max words: ");
		int n = scanner.nextInt();
		scanner.nextLine(); // Consume the leftover newline

		// Use HashMap to count word occurrences
		HashMap<String, Integer> wordCount = new HashMap<>();

		String[] words = str.split("\\s+"); // Splitting words by space

		for (String word : words)
		{
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		// Sort the entries by value in descending order
		List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
		sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

		System.out.println("Word Frequency Count:");
		for (Map.Entry<String, Integer> entry : sortedEntries)
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// Find Nth most frequent word
		if (n > 0 && n <= sortedEntries.size())
		{
			System.out.println("The " + n + "th most frequent word is: " + sortedEntries.get(n - 1).getKey());
		} else
		{
			System.out.println("Invalid Nth value! Choose between 1 and " + sortedEntries.size());
		}

		scanner.close();
	}

}
