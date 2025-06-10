package random_3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Stringrotate {

	public static void main(String[] args) {
		String str = "Programmming78";

		HashSet<Character> hs = new LinkedHashSet<>();

		String newStr = "";
		StringBuilder sb = new StringBuilder(newStr);

		for (char c : str.toCharArray())
			hs.add(c);
		for (char c1 : hs)
			sb.append(c1);

		System.out.println(sb);

	}

}
