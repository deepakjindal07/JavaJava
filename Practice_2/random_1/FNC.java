package random_1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FNC {

	public static void main(String[] args) {
		String str = "Ssisszio";

		HashMap<Character, Integer> hs = new LinkedHashMap<>();

		for (char c : str.toLowerCase().toCharArray())
		{
			if (!hs.containsKey(c))
			{
				hs.put(c, 1);
			} else
			{
				hs.put(c, hs.getOrDefault(hs, 1) + 1);
			}
		}

		for (Entry<Character, Integer> abc : hs.entrySet())
		{
			// System.out.println(abc.getKey() + " " + abc.getValue());
			if (abc.getValue() == 1)
			{
				System.out.println("First " + abc.getKey());
				break;
			}
		}

	}

}
