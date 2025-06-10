package random_7;

import java.util.Scanner;

public class ArrayRepearch {

	public static void main(String[] args) {
		String str;
		char ch;
		int strLen, i, count, j, k, repChars = 0;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the String: ");
		str = s.nextLine();

		strLen = str.length();
		char[] arr = new char[strLen];

		for (i = 0; i < strLen; i++)
			arr[i] = str.charAt(i);

		for (i = 0; i < strLen; i++)
		{
			ch = arr[i];
			count = 0;
			for (j = (i + 1); j < strLen; j++)
			{
				if (ch == arr[j])
				{
					count++;
					for (k = j; k < (strLen - 1); k++)
						arr[k] = arr[k + 1];
					strLen--;
					j--;
				}
			}
			if (count > 0)
				repChars++;
		}

		System.out.println("\nTotal Number of Repeated Characters = " + repChars);
	}

}
