package seleniumTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringCollection {

	public static void main(String[] args) {
		String str1 = "abababa";
		char[] Str_arr = str1.toCharArray();
		String[] Str2 = str1.split(" ");
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= Str2.length - 1; i++)
		{
			String Str2Result = removeDup(Str2[i]);
			map.put(Str2Result, Str2Result.length() - 1);
		}
		String highestKey = getHighestValueKey(map);
		System.out.println("Key with the highest value: " + highestKey); // Output: highest

	}

	private static String getHighestValueKey(Map<String, Integer> map) {
		// Initialize variables to track the key with the highest value
		String highestKey = null;
		int highestValue = Integer.MIN_VALUE;

		// Iterate through the map
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > highestValue)
			{
				highestValue = entry.getValue();
				highestKey = entry.getKey();
			}
		}
		return highestKey;
	}

	private static String removeDup(String string) {
		// Use a HashSet to track unique characters
		Set<Character> seen = new HashSet<>();
		StringBuilder result = new StringBuilder();

		for (char c : string.toCharArray())
		{
			// Add the character only if it has not been seen before
			if (!seen.contains(c))
			{
				seen.add(c);
				result.append(c);
			}
		}
		return result.toString();
	}
}
