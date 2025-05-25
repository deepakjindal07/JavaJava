package pack3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveRepeat {

	public static void main(String[] args) {
		String str = "programming7";
		// output = programing
		String newone = "";
		HashSet<Character> hs = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder(newone);

		for (char c : str.toCharArray()) hs.add(c);
		for (char c : hs)sb.append(c);
		System.out.println(sb);

	}

}
