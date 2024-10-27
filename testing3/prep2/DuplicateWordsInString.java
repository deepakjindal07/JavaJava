package prep2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Java Program to Find Duplicate Words in a String
 * Author: https://www.javaguides.net/
 */
public class DuplicateWordsInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for input
        System.out.print("Enter a string to find duplicate words: ");
        String input = scanner.nextLine();

        // Step 2: Split the string into words
        String[] words = input.toLowerCase().split("\\W+");

        // Step 3: Use a HashMap to track word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0));

            	//	.getOrDefault(word, 0) + 1);
        }

        // Step 4: Identify and display duplicate words
        System.out.print("Duplicate words: ");
        boolean hasDuplicates = false;
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
                hasDuplicates = true;
            }
        }

        if (!hasDuplicates) {
            System.out.print("No duplicates found.");
        }

        System.out.println();
    }
}