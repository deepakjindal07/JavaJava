package temp;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class StringCollection {
	public static void main(String[] args) {

		String str = "Hellqwertyui dupplicate woords";
		String[] NewStr = str.split(" ");

		int max = 0;
		String Max = null;
		for (int i = 0; i < NewStr.length; i++)
		{
			int len = removeDupl(NewStr[i]);

			if (len > max)
			{
				max = len;
				Max = NewStr[i];
			}

		}
		System.out.println(" Max Lenght: " + max);
		System.out.println(" Max Word: " + Max);

	}

	private static int removeDupl(String newStr) {

		String x = newStr;
		char[] x1 = x.toCharArray();
		// System.out.println(x);
		HashSet<Character> hs = new LinkedHashSet<>();

		for (int i = 0; i < x1.length - 1; i++)
		{
			hs.add(x1[i]);
		}

		// System.out.println(hs.size());

		int len = 0;
		for (char ar : hs)
		{
			// System.out.print(ar);
			len++;
		}
		return len;

	}

}
