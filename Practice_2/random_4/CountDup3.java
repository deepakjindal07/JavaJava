package random_4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountDup3 {

	public static void main(String[] args) {

		String str = "hello nash World hello hello";

		HashMap<Character, Integer> map = new HashMap<>();

		char[] chArr = str.toCharArray();

		for (char c : chArr)
		{

			if (!map.containsKey(c))
			{
				map.put(c, 1);
			} else
			{
				map.put(c, map.getOrDefault(c, 1) + 1);
			}

		}

		// Iterator Method.
		Iterator<HashMap.Entry<Character, Integer>> iterator = map.entrySet().iterator();

		while (iterator.hasNext())
		{
			HashMap.Entry<Character, Integer> entry = iterator.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());

		}

		// forEach()
		map.forEach((key, value) -> System.out.println(key + " -> " + value));

		// Enhanced for-loop (Simple & Recommended)
		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}
}
