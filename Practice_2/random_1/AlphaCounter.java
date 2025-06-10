package random_1;

import java.util.HashSet;
import java.util.Set;

public class AlphaCounter {

	public static void main(String[] args) {
		String ant = "bbbaccdddd";

		char[] ch = ant.toCharArray();
		Set<Character> se = new HashSet<>();

		for (int i = 0; i < ant.length(); i++)
		{
			if (!se.contains(ch[i]))
			{
				se.add(ch[i]);
				System.out.print(ch[i]);
				int count = 0;

				for (int j = 0; j < ant.length(); j++)
				{
					if (ch[i] == ch[j])
					{
						count++;
					}
				}

				System.out.print(count);
			}
		}

	}

}
