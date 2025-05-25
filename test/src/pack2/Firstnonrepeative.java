package pack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Firstnonrepeative {

	public static void main(String[] args) {
		char[] ch = { 'a', 'a', 'a', 'c', 'd', 'd', 'e' };

		Map<Character, Integer> map = new HashMap<>();

		for (char x : ch)
		{

			if (!map.containsKey(x))
			{
				map.put(x, 1);

			} else
			{
				map.put(x, map.get(x) + 1);
			}
		}

		int count = 100;
		char ch2 = 0;
		for (Entry<Character, Integer> prt : map.entrySet())
		{
			if (prt.getValue() < count)
			{
				ch2 = prt.getKey();
				count = prt.getValue();
			}
		}

		System.out.println(map);
		System.out.println("Count: " + count + " Value: " + ch2);

	}

}
