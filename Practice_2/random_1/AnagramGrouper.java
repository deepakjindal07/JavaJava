package random_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouper {

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String word : strs)
		{
			// Convert the word to character array and sort it
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			
			for(char c: chars) {
				System.out.println("chars "+c);
			}
			
			String sorted = new String(chars);

			System.out.println("Sorted "+ sorted);
			
			
			// Use sorted string as key
			if (!map.containsKey(sorted))
			{
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(word);
		}

		// Collect the grouped anagrams
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strA = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> result = groupAnagrams(strA);

		for (List<String> group : result)
		{
			System.out.println(group);
		}
	}
}
