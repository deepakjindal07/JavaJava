package random_4;

import java.util.HashMap;

public class HashmapCounter {

	public static void main(String[] args) {
		String str = "Hello World Be Amazed";
		char[] ch = str.toCharArray();

		HashMap<Character, Integer> map = new HashMap<>();

		for (char s : ch) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}


		} System.out.println(map);

	}

}
