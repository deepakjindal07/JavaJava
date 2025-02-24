package interview;

import java.util.Arrays;

public class FirstDup {

	public static void main(String[] args) {
		String str = "abccde";
		char[] ch = str.toCharArray();

		Arrays.sort(ch);

		for (int i = 0; i < str.length() - 1; i++)
		{
			if (ch[i] == ch[i + 1])
			{
				System.out.println("Duplicate:" + ch[i]);
			}
		}

	}

}
