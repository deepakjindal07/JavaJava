package random_1;

import java.util.HashSet;
import java.util.Set;

public class CharCounter {

	public static void main(String[] args) {
		String str = "aaabccddddee";
		char[] ch = str.toCharArray();

		Set<Character> hs = new HashSet<>();

		for (int i = 0; i < str.length(); i++)
		{
			if (!hs.contains(ch[i]))
			{
				hs.add(ch[i]);
				System.out.print(ch[i]);
				int counter = 0;
				for (int j = 0; j < str.length(); j++)
				{
					if (ch[i] == ch[j])
					{
						counter++;

					}
				}
				System.out.print(counter);
			}

		}

	}

}
