package prep5;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDupWords {

	public static void main(String[] args) {
		String str = "Hello Hello java World World";

		String[] ch = str.split(" ");

		Set<String> hs = new LinkedHashSet<>();
		for (int i = 0; i <= ch.length-1; i++) {
			hs.add(ch[i]);
		}

		for (String word : hs) {
			System.out.print(word);

		}

	}
}
