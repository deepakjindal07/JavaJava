package interview;

import java.util.Scanner;

public class ArrayWordCount {

	public static void main(String[] args) {
		int len, i, k, count, prevLen, arri = 0, arrLen = 0;
		String str;
		char ch;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter the String: ");
		str = s.nextLine();

		len = str.length();
		char[][] arr = new char[len][2];

		for (i = 0; i < len; i++)
		{
			ch = str.charAt(i);
			count = 0;
			for (k = 0; k < arrLen; k++)
			{
				if (ch == arr[k][0])
				{
					prevLen = (arr[k][1]);
					prevLen = prevLen + 1;
					arr[k][1] = (char) prevLen;
					count++;
					break;
				}
			}
			if (count == 0)
			{
				arr[arri][0] = ch;
				arr[arri][1] = '1';
				arrLen++;
				arri++;
			}
		}
		for (i = 0; i < arrLen; i++)
			System.out.println(arr[i][0] + " -> " + arr[i][1]);
	}

}
