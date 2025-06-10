package random_7;

import java.util.HashMap;
import java.util.Map;

public class Firstnonrep {

	public static void main(String[] args) {
		String s = "racecars";
		char[] ch = s.toCharArray();

		firstnonrep(ch);

	}

	private static void firstnonrep(char[] ch) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : ch)
		{
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// Step 2: Find the first non-repeating character
//		for (char c : ch)
//		{
//			
		for (char c : ch)
		{
			if (map.get(c) == 1)
			{ // Checking if the character appears only once
				System.out.println("First non-repeating character: " + c);
				return;
			}
		}

		// Read data using entrySet()
//		for (Map.Entry<Character, Integer> entry : map.entrySet())
//		{
//			char key = entry.getKey(); // Get the key
//			int value = entry.getValue(); // Get the value
//			System.out.println("Key: " + key + ", Value: " + value);
//		}

	}
}
