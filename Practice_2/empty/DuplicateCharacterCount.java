package empty;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicateCharacterCount {

	public static void main(String[] args) {
		String str = "aabbbcdef";

		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char c : str.toCharArray())
		{

			map.put(c, map.getOrDefault(c, 0) + 1);

		}

		System.out.println(map.toString());

		for (Map.Entry<Character, Integer> ip : map.entrySet())
		{
			System.out.println(ip.getKey());
			System.out.print(ip.getValue());

		}

	}

}
